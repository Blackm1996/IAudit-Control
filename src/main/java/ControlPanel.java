import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.ArrayList;

public class ControlPanel extends JFrame
{
    JButton edit,delete;

    ArrayList<NewPattern> allPaterns;
    JList<NewPattern> patternsList;
    JPanel bottomPanel;
    JScrollPane content;
    public ControlPanel()
    {
        ini_Components();
    }

    private void ini_Components()
    {

        Border border = BorderFactory.createLineBorder(new Color(76,79,83));
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("ToolTip.background", new ColorUIResource(255, 247, 200));
            UIManager.put("ToolTip.border", border);
        }catch(Exception e){
            System.out.println("Unable to set LookAndFeel");
        }
        setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(500, 500);
        //setTray();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        ViewPatterns();
        setVisible(true);
    }

    public void newPattern()
    {
        if (content!=null)
            getContentPane().remove(content);
        NewPattern pattern=new NewPattern(this);
        content=new JScrollPane(pattern);
        getContentPane().add(content,BorderLayout.CENTER);
        setBottomPanel(false);
        revalidate();
        repaint();
    }

    public void newPattern(NewPattern pattern1,int index_in_list)
    {
        if (content!=null)
            getContentPane().remove(content);
        NewPattern pattern=new NewPattern(this,pattern1.sequences,index_in_list);
        //pattern.readyToShow();
        content=new JScrollPane(pattern);
        getContentPane().add(content,BorderLayout.CENTER);
        setBottomPanel(false);
        revalidate();
        repaint();
    }

    public void ViewPatterns()
    {
        if (content!=null)
            getContentPane().remove(content);

        loadPatterns();
        DefaultListModel<NewPattern> listModel = new DefaultListModel<>();
        for (NewPattern pattern:allPaterns)
            listModel.addElement(pattern);

        patternsList = new JList<>(listModel);
        patternsList.addListSelectionListener(listSelectionEvent -> {
            int[] selectedIndexes=((JList)listSelectionEvent.getSource()).getSelectedIndices();
            if (selectedIndexes.length!=0)
            {
                delete.setEnabled(true);
                if (selectedIndexes.length==1)
                    edit.setEnabled(true);
                else
                    edit.setEnabled(false);
            }
            else
            {
                edit.setEnabled(false);
                delete.setEnabled(false);
            }
        });

        patternsList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList<NewPattern> list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    if(list.getSelectedIndices().length==1&&list.getSelectedIndex()==index)
                    {
                        newPattern(list.getModel().getElementAt(index),index);
                    }
                }
            }
        });

        content=new JScrollPane(patternsList);
        getContentPane().add(content,BorderLayout.CENTER);
        setBottomPanel(true);
        revalidate();
        repaint();
    }

    private void setTray()
    {
        TrayIcon trayIcon;
        SystemTray tray;
        if(SystemTray.isSupported())
            tray=SystemTray.getSystemTray();
        else
        {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            return;
        }

        Image image=Toolkit.getDefaultToolkit().getImage(".\\src\\main\\resources\\Icons\\icons8-java-96.png");
        ;
        PopupMenu popup=new PopupMenu();
        MenuItem defaultItem=new MenuItem("Open");
        defaultItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(true);
                setExtendedState(JFrame.NORMAL);
            }
        });
        popup.add(defaultItem);
        defaultItem=new MenuItem("Exit");
        defaultItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        popup.add(defaultItem);

        trayIcon=new TrayIcon(image, "IAudit-Control Panel", popup);
        trayIcon.setImageAutoSize(true);
        trayIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getButton()==MouseEvent.BUTTON1)
                {
                    setVisible(true);
                    setExtendedState(JFrame.NORMAL);
                }
            }
        });

        try {
            tray.add(trayIcon);
            setVisible(false);
        } catch (AWTException ex) {
            System.out.println("unable to add to tray");
        }
    }

    private void setBottomPanel(boolean editDelete)
    {
        if(bottomPanel!=null)
            getContentPane().remove(bottomPanel);
        bottomPanel=new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder());
        bottomPanel.setLayout(new GridLayout(0,1));
        add(bottomPanel, BorderLayout.SOUTH);
        if (editDelete)
        {
            JPanel panel=new JPanel();
            panel.setBorder(BorderFactory.createLineBorder(Color.darkGray));
            edit=new JButton("Edit");
            edit.setActionCommand("Edit");
            edit.addActionListener(new Act());
            edit.setEnabled(false);
            panel.add(edit);
            delete=new JButton("Delete");
            delete.setActionCommand("Delete");
            delete.addActionListener(new Act());
            delete.setEnabled(false);
            panel.add(delete);
            bottomPanel.add(panel);
        }
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JToolBar toolbar=new JToolBar();

        if (!editDelete)
        {
            JButton back = new JButton(Utils.im(".\\src\\main\\resources\\Icons\\restart-1.png"));
            back.setFocusable(false);
            back.setBorderPainted(false);
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    ViewPatterns();
                }
            });

            toolbar.add(back);
            toolbar.addSeparator(new Dimension(10,25));
        }

        JButton newPat = new JButton(Utils.im(".\\src\\main\\resources\\Icons\\new_doc.jpg"));
        newPat.setFocusable(false);
        newPat.setBorderPainted(false);
        newPat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                newPattern();
            }
        });
        toolbar.add(newPat);
        toolbar.addSeparator(new Dimension(10,25));
        statusPanel.add(toolbar);
        bottomPanel.add(statusPanel);
        revalidate();
        repaint();
    }

    private void loadPatterns()
    {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .serializeNulls()
                .setPrettyPrinting()
                .create();

            java.lang.reflect.Type listType = new TypeToken<ArrayList<NewPattern>>(){}.getType();
            JsonReader reader=null;
            try {
                reader= new JsonReader(new FileReader("D:\\mohye\\IdeaProjects\\IAudit-Control-Swing\\src\\main\\resources\\JSON\\Patterns.json"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            allPaterns = gson.fromJson(reader, listType);
    }


    private class Act implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            switch (actionEvent.getActionCommand())
            {
                case "Delete":
                {
                    Gson gson = new GsonBuilder()
                            .excludeFieldsWithoutExposeAnnotation()
                            .serializeNulls()
                            .setPrettyPrinting()
                            .create();
                        java.lang.reflect.Type listType = new TypeToken<ArrayList<NewPattern>>(){}.getType();
                        for (int i=0;i<patternsList.getSelectedIndices().length;i++)
                        {
                            NewPattern p=patternsList.getModel().getElementAt(patternsList.getSelectedIndices()[i]);
                            //i--;
                            allPaterns.remove(p);
                        }
                    JsonWriter writer;
                    try {
                        writer=new JsonWriter(new FileWriter("D:\\mohye\\IdeaProjects\\IAudit-Control-Swing\\src\\main\\resources\\JSON\\Patterns.json"));
                        gson.toJson(allPaterns,listType,writer);
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ViewPatterns();
                    break;
                }
                case "Edit":
                {
                    newPattern(patternsList.getSelectedValue(),patternsList.getSelectedIndex());
                    break;
                }
            }
        }
    }
}
