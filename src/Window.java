import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private int WIDTH=600;
    private int HEIGHT=300;
    Panel panel=new Panel();


    public Window() { //בנאי לחלון
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //פעולה לכפתור האיקס
        this.add(panel);
        this.setBounds(20,20,20,20);
        this.setResizable(false); //לאפשר שינוי גודל חלון
        this.setSize(WIDTH, HEIGHT); //הגדרת גודל החלון
        this.setLocationRelativeTo(null);
        this.setVisible(true); // הגדרת נראות חלון
    }
}

