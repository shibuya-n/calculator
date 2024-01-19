import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public GUI(){
        super("CALCULATOR");
        Container c = getContentPane();
        c.setLayout(new GridLayout(3,1));

        JPanel y = new JPanel();
        y.setLayout(new FlowLayout());

        JPanel z = new JPanel();
        z.setLayout(new FlowLayout());
    }
    public static void main(String[] args) {
        GUI window = new GUI();
        window.setVisible(true);
        window.setBounds(100,100,300,100);
        window.setResizable(true);

        y.add(new JTextField("Derivative Calculator"));
        y.add()

    }
}