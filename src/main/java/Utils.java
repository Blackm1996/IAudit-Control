import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Utils
{
    public static ImageIcon im(String s)
    {
        ImageIcon im=new ImageIcon(s);
        Image image = im.getImage(); // transform it
        Image newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        return new ImageIcon(newimg);
    }

    public static ImageIcon im2(String s)
    {
        ImageIcon im=new ImageIcon(s);
        Image image = im.getImage(); // transform it
        Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        return new ImageIcon(newimg);
    }
    static class FocusListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            mouseEvent.getComponent().requestFocus();
        }
    }
}
