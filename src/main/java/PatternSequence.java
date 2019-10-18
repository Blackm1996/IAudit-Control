import com.google.gson.annotations.Expose;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PatternSequence extends JPanel
{
   public static final String begin="begin";
    public static final String next="next";
    public static final String followed_by="followedBy";
    @Expose
    String name="";
    @Expose
    String type;
    JLabel name_label;
    JTextField change_name;
    JToolBar toolbar;
    JButton add;
    JButton delete;
    JPanel main;

    @Expose
    ArrayList<Condition> conditions=new ArrayList<>();
    public PatternSequence(String type,String name,ArrayList<Condition> conditions)
    {
        super();
        this.type=type;
        this.name=name;
        this.conditions=new ArrayList<>();
        for (Condition d:conditions)
        {
            this.conditions.add(new Condition(d.type,d.expression,d.time,d.unit));
        }
        setBorder(BorderFactory.createLineBorder(Color.darkGray));
        setFocusable( true );
        setLayout(new BorderLayout());
        addMouseListener(new Utils.FocusListener());
        setBottomPanel();
        setTopPanel();
        main=new JPanel();
        main.setLayout(new GridBagLayout());
        JScrollPane scrollPane=new JScrollPane(main);
        add(scrollPane,BorderLayout.CENTER);
        readyToShow();
    }

    public PatternSequence(String type,String name)
    {
        super();
        this.name=name;
        this.type=type;
        setBorder(BorderFactory.createLineBorder(Color.darkGray));
        setFocusable( true );
        setLayout(new BorderLayout());
        addMouseListener(new Utils.FocusListener());
        setBottomPanel();
        setTopPanel();
        //setMinimumSize(new Dimension(0,50));
        main=new JPanel();
        main.setLayout(new GridBagLayout());
        JScrollPane scrollPane=new JScrollPane(main);
        add(scrollPane,BorderLayout.CENTER);
        addCondition(Condition.where,0);
    }

    private void setBottomPanel()
    {
        JPanel statusPanel = new JPanel();
        add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        /*JLabel statusLabel = new JLabel("status");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);*/
        toolbar=new JToolBar();
        add = new JButton(Utils.im(".\\src\\main\\resources\\Icons\\add.png"));
        add.setFocusable(false);
        add.setBorderPainted(false);
        toolbar.add(add);
        delete = new JButton(Utils.im(".\\src\\main\\resources\\Icons\\delete.png"));
        delete.setFocusable(false);
        delete.setBorderPainted(false);
        toolbar.add(delete);
        statusPanel.add(toolbar);
    }

    private void setTopPanel()
    {
        JPanel statusPanel = new JPanel();
        add(statusPanel, BorderLayout.NORTH);
        statusPanel.setFocusable(true);
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JLabel typeLabel=new JLabel(type+" :");
        statusPanel.add(typeLabel);
        statusPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        name_label=new JLabel();
        if (name.isEmpty())
            name_label.setText("new Pattern");
        else
            name_label.setText(name);
        name_label.setBorder(BorderFactory.createEmptyBorder());
        name_label.setHorizontalAlignment(SwingConstants.LEFT);
        change_name=new JTextField(name);
        change_name.setHorizontalAlignment(SwingConstants.LEFT);
        name_label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if ((mouseEvent.getButton()==MouseEvent.BUTTON1)&&(mouseEvent.getClickCount()==2))
                {
                    statusPanel.remove(name_label);
                    change_name.setText(name_label.getText());
                    statusPanel.add(change_name);
                    change_name.requestFocus();
                    statusPanel.revalidate();
                    statusPanel.repaint();
                }
            }
        });
        change_name.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent focusEvent) {
                statusPanel.add(name_label);
                statusPanel.remove(change_name);
                name_label.setText(change_name.getText());
                name=change_name.getText();
                statusPanel.revalidate();
                statusPanel.repaint();
            }
        });
        statusPanel.add(name_label);
    }


    private void addCondition(String type,int position)
    {
        GridBagConstraints c=new GridBagConstraints();
        Condition condition=new Condition(type);
        condition.getAdd().addActionListener(new ShowMenu());
        if (conditions.size()==0)
            condition.removetDeleteButton();

        condition.getDelete().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    removeCondition(condition);
                }
            });

        for (int i=position;i<conditions.size();i++)
        {
            main.remove(conditions.get(i));
        }

        conditions.add(position,condition);
        for (int i=position;i<conditions.size();i++)
        {
            c.fill=GridBagConstraints.HORIZONTAL;
            c.gridx=0;
            c.gridy=i;
            c.weighty=1;
            c.weightx=1;
            c.anchor=GridBagConstraints.FIRST_LINE_START;
            main.add(conditions.get(i),c);
        }
        main.revalidate();
        main.repaint();
    }

    private void removeCondition(Condition condition)
    {
        main.remove(condition);
        conditions.remove(condition);
        main.revalidate();
        main.repaint();
    }

    public JButton getAdd() {
        return add;
    }


    public JButton getDelete() {
        return delete;
    }

    public void removeDeleteButton() {
        delete.getParent().remove(delete);
    }

    public boolean ready()
    {
        for (Condition c:conditions)
        {
            if (!c.ready())
                return false;
        }
        return true;
    }


    public void readyToShow()
    {
        for (int i=0;i<conditions.size();i++)
        {
            GridBagConstraints c=new GridBagConstraints();
            Condition condition=conditions.get(i);
            //condition.readyToShow();
            condition.getAdd().addActionListener(new ShowMenu());
            if (i==0)
                condition.removetDeleteButton();

            condition.getDelete().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    removeCondition(condition);
                }
            });
            c.fill=GridBagConstraints.HORIZONTAL;
            c.gridx=0;
            c.gridy=i;
            c.weighty=1;
            c.weightx=1;
            c.anchor=GridBagConstraints.FIRST_LINE_START;
            main.add(condition,c);
            main.revalidate();
            main.repaint();
        }
    }

    private class ShowMenu implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            final JPopupMenu menu = new JPopupMenu();
            JButton b=(JButton)actionEvent.getSource();
            Condition finalParent = (Condition) b.getParent().getParent();

            JMenuItem where=new JMenuItem(Condition.where);
            where.addActionListener(actionEvent1 -> addCondition(Condition.where, conditions.indexOf(finalParent) + 1));

            JMenuItem onOrMore=new JMenuItem(Condition.onOrMore);
            onOrMore.addActionListener(actionEvent1 -> addCondition(Condition.onOrMore,conditions.indexOf(finalParent)+1));

            JMenuItem times=new JMenuItem(Condition.times);
            times.addActionListener(actionEvent1 -> addCondition(Condition.times,conditions.indexOf(finalParent)+1));

            JMenuItem timesOrMore=new JMenuItem(Condition.timesOrMore);
            timesOrMore.addActionListener(actionEvent1 -> addCondition(Condition.timesOrMore,conditions.indexOf(finalParent)+1));

            JMenuItem within=new JMenuItem(Condition.within);
            within.addActionListener(actionEvent1 -> addCondition(Condition.within,conditions.indexOf(finalParent)+1));

            menu.add(where);
            menu.add(onOrMore);
            menu.add(times);
            menu.add(timesOrMore);
            menu.add(within);
            menu.show(b,b.getX(),b.getY());
        }
    }


}