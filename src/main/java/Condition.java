import com.google.gson.annotations.Expose;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;


public class Condition extends JPanel
{
    public static final String where="where";
    public static final String onOrMore="oneOrMore";
    public static final String times="times";
    public static final String timesOrMore="timesOrMore";
    public static final String within="within";

    String[] times_unit={"milliseconds","seconds","minutes","hours","days"};

    @Expose
    String type;

    JButton add,delete,error;

    SimpleSyntaxTextArea expressionField;
    JFormattedTextField timeField;
    JComboBox<String> unitCombo;
    boolean err=false;

    @Expose
    String expression;
    @Expose
    String time;
    @Expose
    String unit;

    public Condition(String type)
    {
        super();
        this.type=type;
        setFocusable(true);
        setBorder(BorderFactory.createLineBorder(Color.lightGray));
        addMouseListener(new Utils.FocusListener());
        construct();
        revalidate();
        repaint();
    }

    public Condition(String type, String expression, String time, String unit) {
        super();
        this.type = type;
        this.expression = expression;
        this.time = time;
        this.unit = unit;
        setFocusable(true);
        setBorder(BorderFactory.createLineBorder(Color.lightGray));
        addMouseListener(new Utils.FocusListener());
        construct();
        readyToShow();
        revalidate();
        repaint();
    }

    private void construct()
    {
        switch (type)
        {
            case (Condition.where):
            {
                error=new JButton(Utils.im(".\\src\\main\\resources\\Icons\\no_error.png"));
                expressionField=new SimpleSyntaxTextArea(this);
                setLayout(new BorderLayout());

                error.setBorder(BorderFactory.createEmptyBorder());
                error.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        expressionField.dialog.setVisible(true);
                    }
                });
                JPanel up=setTopPanel();
                up.setMaximumSize(new Dimension(Integer.MAX_VALUE,25));
                JPanel down=setBottomPanel();
                down.setMaximumSize(new Dimension(Integer.MAX_VALUE,25));
                add(down, BorderLayout.SOUTH);
                add(up, BorderLayout.NORTH);

                JScrollPane p=new JScrollPane(expressionField);
                p.setPreferredSize(new Dimension(getPreferredSize().width,200));
                add(p,BorderLayout.CENTER);
                //System.out.println(error.getSize()+" , "+error.getLocation());
                break;
            }
            case (Condition.onOrMore):
            {
                GridBagLayout layout=new GridBagLayout();
                GridBagConstraints c=new GridBagConstraints();
                setLayout(layout);
                JPanel up=setTopPanel();
                c.fill=GridBagConstraints.HORIZONTAL;
                c.gridx=0;
                c.gridy=0;
                c.anchor=GridBagConstraints.LINE_START;
                add(up,c);
                JPanel down=setBottomPanel();
                c.insets = new Insets(2,0,0,0);
                c.fill=GridBagConstraints.HORIZONTAL;
                c.gridx=0;
                c.anchor=GridBagConstraints.LINE_START;
                c.gridy=1;
                c.weighty=1;
                c.weightx=1;
                add(down,c);
                break;
            }
            case (Condition.times):
            case (Condition.timesOrMore):
            {
                GridBagLayout layout=new GridBagLayout();
                GridBagConstraints c=new GridBagConstraints();
                setLayout(layout);
                JPanel panel=setTopPanel();
                Format t= NumberFormat.getIntegerInstance();
                timeField =new JFormattedTextField(t);
                timeField.setPreferredSize(new Dimension(25,25));
                panel.add(Box.createRigidArea(new Dimension(10, 0)));
                panel.add(timeField);
                c.fill=GridBagConstraints.HORIZONTAL;
                c.gridx=0;
                c.gridy=0;
                c.weighty=1;
                c.weightx=1;
                c.anchor=GridBagConstraints.LINE_START;
                add(panel,c);
                JPanel down=setBottomPanel();
                c.insets = new Insets(2,0,0,0);
                c.fill=GridBagConstraints.HORIZONTAL;
                c.gridx=0;
                c.weighty=0;
                c.weightx=0;
                c.anchor=GridBagConstraints.LINE_START;
                c.gridy=1;
                add(down,c);

                break;
            }
            case (Condition.within):
            {
                GridBagLayout layout=new GridBagLayout();
                GridBagConstraints c=new GridBagConstraints();
                setLayout(layout);
                JPanel panel=setTopPanel();
                Format t= NumberFormat.getIntegerInstance();
                timeField =new JFormattedTextField(t);
                timeField.setPreferredSize(new Dimension(25,25));
                panel.add(Box.createRigidArea(new Dimension(10, 0)));
                panel.add(timeField);
                unitCombo=new JComboBox<>(times_unit);
                unitCombo.setSelectedIndex(1);
                panel.add(Box.createRigidArea(new Dimension(10, 0)));
                panel.add(unitCombo);
                c.fill=GridBagConstraints.HORIZONTAL;
                c.gridx=0;
                c.gridy=0;
                c.weighty=1;
                c.weightx=1;
                c.anchor=GridBagConstraints.LINE_START;
                add(panel,c);
                JPanel down=setBottomPanel();
                c.insets = new Insets(2,0,0,0);
                c.fill=GridBagConstraints.HORIZONTAL;
                c.gridx=0;
                c.weighty=0;
                c.weightx=0;
                c.anchor=GridBagConstraints.LINE_START;
                c.gridy=1;
                add(down,c);
                break;
            }
        }
    }

    private JPanel setTopPanel()
    {
        JPanel statusPanel = new JPanel();
        statusPanel.setFocusable(true);
        if (type.equals(Condition.where))
        {

            statusPanel.setLayout(new BorderLayout());
            statusPanel.add(error,BorderLayout.EAST);
            JLabel typeLabel=new JLabel(type);
            statusPanel.add(typeLabel,BorderLayout.WEST);
        }
        else
        {
            statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
            JLabel typeLabel=new JLabel(type);
            statusPanel.add(typeLabel);
        }


        return statusPanel;
    }

    private JPanel setBottomPanel()
    {
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        add=new JButton("+");
        delete=new JButton("-");
        statusPanel.add(add);
        statusPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        statusPanel.add(delete);
        return statusPanel;
    }

    public JButton getAdd() {
        return add;
    }


    public JButton getDelete() {
        return delete;
    }

    public void removetDeleteButton() {
        delete.getParent().remove(delete);
    }

    public boolean ready()
    {
        switch (type)
        {
            case (Condition.where):
            {
                expression=expressionField.getText();
                return !err;
            }
            case (Condition.onOrMore):
            {
                return true;
            }
            case (Condition.times):
            case (Condition.timesOrMore):
            case (Condition.within):
            {
                try {
                    timeField.commitEdit();
                } catch (ParseException e) {
                    System.out.println("not number");
                    return false;
                }
                time=timeField.getText();
                if(unitCombo!=null)
                {
                    unit=String.valueOf(unitCombo.getSelectedItem());
                }
                return true;
            }
            default:
                System.out.println("wrong type");
                return false;
        }
    }

    public void readyToShow()
    {
       /* setFocusable(true);
        setBorder(BorderFactory.createLineBorder(Color.lightGray));
        addMouseListener(new Utils.FocusListener());*/
        switch (type)
        {
            case (Condition.where):
            {
                expressionField.setText(expression);
                break;
            }
            case (Condition.times):
            case (Condition.timesOrMore):
            case (Condition.within):
            {
                timeField.setText(time);
                if(unitCombo!=null)
                {
                    unitCombo.setSelectedItem(unit);
                }
                break;
            }
        }
    }

    public void changeError(boolean err)
    {
        this.err=err;
        if (err)
        {
            error.setIcon(Utils.im(".\\src\\main\\resources\\Icons\\error.png"));
            expressionField.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        else
        {
            error.setIcon(Utils.im(".\\src\\main\\resources\\Icons\\no_error.png"));
            expressionField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }
    }
}
