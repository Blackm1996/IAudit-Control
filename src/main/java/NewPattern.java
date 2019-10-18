import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NewPattern extends JPanel
{
    ControlPanel parent;
    boolean edit=false;
    int index_in_list=-1;

    JPanel core;
    @Expose
    ArrayList<PatternSequence> sequences=new ArrayList<>();
    public NewPattern(ControlPanel parent)
    {
        super();
        this.parent=parent;
        core=new JPanel();
        core.setFocusable( true );
        ini();
    }

    public NewPattern(ControlPanel parent,ArrayList<PatternSequence> sequences,int index_in_list)
    {
        super();
        edit=true;
        this.index_in_list=index_in_list;
        this.parent=parent;
        this.sequences=new ArrayList<>();
        for (PatternSequence s:sequences)
        {
            this.sequences.add(new PatternSequence(s.type,s.name,s.conditions));
        }
        readyToShow();
    }

    private void ini()
    {
        setLayout(new BorderLayout());
        core.setLayout(new GridBagLayout());
        addSeqence(PatternSequence.begin,0);
        core.setFocusable(true);
        core.addMouseListener(new Utils.FocusListener());
        add(core,BorderLayout.CENTER);
        setBottomPanel();
    }

    public void setParent(ControlPanel parent) {
        this.parent = parent;
    }

    private void setBottomPanel()
    {
        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(BorderFactory.createEmptyBorder());
        add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        /*JLabel statusLabel = new JLabel("status");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);*/
        JToolBar toolbar=new JToolBar();
        JButton apply = new JButton(Utils.im(".\\src\\main\\resources\\Icons\\check_apply_approved-512.png"));
        apply.setFocusable(false);
        apply.setBorderPainted(false);
        toolbar.add(apply);
        toolbar.addSeparator(new Dimension(3,25));
        apply.addActionListener(new Apply(this));
        statusPanel.add(toolbar);
    }

    private void addSeqence(String type,int position)
    {
        GridBagConstraints c=new GridBagConstraints();
        PatternSequence sequence=new PatternSequence(type,"new Pattern "+sequences.size());
        if (sequences.size()==0)
            sequence.removeDeleteButton();
        sequence.getAdd().addActionListener(new ShowMenu());

        sequence.getDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                removeSequence(sequence);
            }
        });
        for (int i=position;i<sequences.size();i++)
        {
            core.remove(sequences.get(i));
        }
        sequences.add(position,sequence);
        for (int i=position;i<sequences.size();i++)
        {
            c.fill=GridBagConstraints.HORIZONTAL;
            c.gridx=0;
            c.gridy=i;
            c.weighty=1;
            c.weightx=1;
            c.anchor=GridBagConstraints.FIRST_LINE_START;
            core.add(sequences.get(i),c);
        }
        core.revalidate();
        core.repaint();
    }
    private void removeSequence(PatternSequence sequence)
    {
        core.remove(sequence);
        sequences.remove(sequence);
        core.revalidate();
        core.repaint();
    }

    public boolean ready()
    {
        for (PatternSequence c:sequences)
        {
            if (!c.ready())
                return false;
        }
        return true;
    }


    public void readyToShow()
    {
        setLayout(new BorderLayout());
        core=new JPanel();
        core.setFocusable( true );
        core.setLayout(new GridBagLayout());
        core.setFocusable(true);
        core.addMouseListener(new Utils.FocusListener());
        add(core,BorderLayout.CENTER);
        for (int i=0;i<sequences.size();i++)
        {
            PatternSequence sequence=sequences.get(i);
            //sequence.readyToShow();
            GridBagConstraints c=new GridBagConstraints();
            if (i==0)
                sequence.removeDeleteButton();
            sequence.getAdd().addActionListener(new ShowMenu());

            sequence.getDelete().addActionListener(actionEvent -> removeSequence(sequence));

            c.fill=GridBagConstraints.HORIZONTAL;
            c.gridx=0;
            c.gridy=i;
            c.weighty=1;
            c.weightx=1;
            c.anchor=GridBagConstraints.FIRST_LINE_START;
            core.add(sequences.get(i),c);
            core.revalidate();
            core.repaint();
        }
        setBottomPanel();
    }


    @Override
    public String toString()
    {
        return sequences.get(0).name;
    }

    private class ShowMenu implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            final JPopupMenu menu = new JPopupMenu();
            JButton b=(JButton)actionEvent.getSource();
            JMenuItem next=new JMenuItem(PatternSequence.next);
            PatternSequence finalParent = (PatternSequence)b.getParent().getParent().getParent();
            next.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    addSeqence(PatternSequence.next,sequences.indexOf(finalParent)+1);
                }
            });

            JMenuItem followedBy=new JMenuItem(PatternSequence.followed_by);
            followedBy.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    addSeqence(PatternSequence.followed_by,sequences.indexOf(finalParent)+1);
                }
            });

            menu.add(next);
            menu.add(followedBy);
            menu.show(b,b.getX(),b.getY());
        }
    }



    private class Apply implements ActionListener
    {
        NewPattern pattern_to_save;
        public Apply(NewPattern pattern_to_save)
        {
            this.pattern_to_save = pattern_to_save;
        }
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            //AbstractMap.SimpleEntry<String,Integer> entry=new AbstractMap.SimpleEntry<>("tiw",2);
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .serializeNulls()
                    .setPrettyPrinting()
                    .create();
            if (ready())
            {
                java.lang.reflect.Type listType = new TypeToken<ArrayList<NewPattern>>(){}.getType();
                JsonReader reader=null;
                try {
                    reader= new JsonReader(new FileReader("D:\\mohye\\IdeaProjects\\IAudit-Control-Swing\\src\\main\\resources\\JSON\\Patterns.json"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ArrayList<NewPattern> allPaterns = gson.fromJson(reader, listType);
                if (allPaterns==null)
                    allPaterns=new ArrayList<>();
                if (allPaterns.size()!=0&&edit)
                    allPaterns.set(pattern_to_save.index_in_list,pattern_to_save);
                else
                    allPaterns.add(pattern_to_save);
                JsonWriter writer;
                try {
                    writer=new JsonWriter(new FileWriter("D:\\mohye\\IdeaProjects\\IAudit-Control-Swing\\src\\main\\resources\\JSON\\Patterns.json"));
                    gson.toJson(allPaterns,listType,writer);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                parent.ViewPatterns();
            }
        }
    }
}
