import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

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

    public static String getSettings(String setting) throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File("src\\main\\resources\\settings.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName(setting);
        Node n=nList.item(0);
        return n.getTextContent();
    }
}
