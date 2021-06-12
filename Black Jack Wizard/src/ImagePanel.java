
//import java.awt.GridLayout;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JComponent;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
import javax.swing.JPanel;

//import jdk.javadoc.internal.doclets.formats.html.resources.standard;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
import java.awt.Graphics;
import java.awt.Image;
//import java.awt.Toolkit;

class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
