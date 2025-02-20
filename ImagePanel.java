import java.util.*;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel(String imagePath) {
        image = new ImageIcon(imagePath).getImage();
        setPreferredSize(new Dimension(300, 200)); // Fixed image size
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
