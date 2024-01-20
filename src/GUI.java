import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {

    private static JTextField derivativeTextfield = new JTextField(16);
    private static JTextField integralTextfield = new JTextField(16);
    private static JTextField convertTextfield = new JTextField(16);

    public GUI(){
        super("CALCULATOR");
        Container c = getContentPane();
        c.setLayout(new GridLayout(3,1));

        // ROW 1
        JPanel x = new JPanel();
        x.setLayout(new FlowLayout());

        // add text
        x.add(new JLabel("DERIVATIVE CALCULATOR"));

        // add input
        x.add(derivativeTextfield);

        // add button
        JButton deriveButton = new JButton("DERIVE");
        deriveButton.addActionListener(new JButton().getAction());
        x.add(deriveButton);


        // ROW 2
        JPanel y = new JPanel();
        y.setLayout(new FlowLayout());

        // add text
        y.add(new JLabel("INTEGRAL CALCULATOR"));

        // add input
        y.add(integralTextfield);

        // add button
        JButton integralButton = new JButton("INTEGRAL");
        integralButton.addActionListener(new JButton().getAction());
        y.add(integralButton);

        // ROW 3
        JPanel z = new JPanel();
        z.setLayout(new FlowLayout());

        // add selectors
        String[] s1 = {"BINARY"};
        String[] s2 = {"BINARY"};
        JComboBox binaryBox1 = new JComboBox(s1);
        JComboBox binaryBox2 = new JComboBox(s2);
        z.add(binaryBox1);
        z.add(new JLabel("to"));
        z.add(binaryBox2);

        // add input
        z.add(convertTextfield);

        // add button
        JButton convertButton = new JButton("CONVERT");
        convertButton.addActionListener(new JButton().getAction());
        z.add(convertButton);




        c.add(x);
        c.add(y);
        c.add(z);

    }
    public static void main(String[] args) {
        GUI window = new GUI();
        window.setVisible(true);
        window.setBounds(100,100,800,300);
        window.setResizable(true);




    }
}