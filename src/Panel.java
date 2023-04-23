import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JLabel {
    private float widthCalculation;
    private float heightCalculation;
    private float lengthCalculation;
    private float value;



    public Panel() {
        JLabel width = new JLabel("width :");
        width.setBounds(40, 20, 50, 20);
        width.setForeground(Color.black);
        this.add(width);
        width.setVisible(true);

        JTextField widthField = new JTextField("");
        widthField.setBounds(100, 20, 70, 20);
        this.add(widthField);
        widthField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    value = Float.parseFloat(widthField.getText());
                    widthCalculation = value;
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid number");
                    widthField.setText("");
                }
            }
        });

        JLabel height = new JLabel("height :");
        height.setBounds(40, 60, 50, 20);
        height.setForeground(Color.black);
        this.add(height);
        height.setVisible(true);

        JTextField heightField = new JTextField();
        heightField.setBounds(100, 60, 70, 20);
        this.add(heightField);
        heightField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    value = Float.parseFloat(heightField.getText());
                    heightCalculation = value;
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid number");
                    heightField.setText("");
                }
            }
        });

        JLabel length = new JLabel("length :");
        length.setBounds(40, 100, 50, 20);
        length.setForeground(Color.black);
        this.add(length);
        length.setVisible(true);

        JTextField lengthField = new JTextField();
        lengthField.setBounds(100, 100, 70, 20);
        this.add(lengthField);
        lengthField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    value = Float.parseFloat(lengthField.getText());
                    lengthCalculation = value;
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid number");
                    lengthField.setText("");
                }
            }
        });

        JButton calculateButton = new JButton("calculate");
        this.add(calculateButton);
        calculateButton.setBounds(100, 160, 120, 30);
        calculateButton.setVisible(true);
        new Thread(() -> {
            while (true) {
                if (isEmpty(lengthField.getText()) || isEmpty(heightField.getText()) || isEmpty(widthField.getText())) {
                    calculateButton.setEnabled(false);
                } else {
                    calculateButton.setEnabled(true);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        calculateButton.addActionListener(e -> {
            float volume = (lengthCalculation * widthCalculation * heightCalculation);
            float area = ((2 * widthCalculation * heightCalculation) + (2 * widthCalculation * lengthCalculation) + (2 * lengthCalculation * heightCalculation));
            JOptionPane.showMessageDialog(null, "Volume is " + volume + ".   " +
                    " Area is " + area);
        });
    }
    public boolean isEmpty(String text) {
        if (text.equals("")) {
            return true;
        } else {
            return false;
        }
    }
}










