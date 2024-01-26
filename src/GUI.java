import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI{

    private static JTextField derivativeTextfield = new JTextField(16);
    private static JTextField integralTextfield = new JTextField(16);
    private static JTextField convertTextfield = new JTextField(16);


    public static void createGUI(){
        JLabel errorV = new JLabel();
        JLabel errorT = new JLabel();
        JLabel errorI = new JLabel();

        // create window
        JFrame window = new JFrame("Advanced Calculator");
        window.setLayout(new GridLayout(6,1));

        // volume section
        JPanel volumeLabel = new JPanel();
        volumeLabel.setLayout(new FlowLayout());
        JLabel volume = new JLabel("CALCULATE VOLUME OF A SPHERE");
        volumeLabel.add(volume);

        JPanel volumeCalc = new JPanel();
        volumeCalc.setLayout(new FlowLayout());
        JLabel volumePrompt = new JLabel("RADIUS");
        JTextField volumeInput = new JTextField(8);
        JButton volumeButton = new JButton("Go");

        volumeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = 0;

                try {
                    input = Integer.parseInt(volumeInput.getText());
                    double result = calculateVolume(input);

                    JFrame resultWindow = new JFrame("YOUR VOLUME");
                    resultWindow.setLayout(new FlowLayout());
                    resultWindow.setBounds(100,100,300,150);
                    resultWindow.add(new JLabel(String.valueOf(result)));
                    resultWindow.setResizable(false);
                    resultWindow.setVisible(true);


                } catch (Exception f) {
                     errorV.setText( "Error. Please input a number");

                }

            }
        });

        volumeCalc.add(volumePrompt);
        volumeCalc.add(volumeInput);
        volumeCalc.add(volumeButton);

        // find missing angle
        JPanel traingl

        // find compound interest



        window.add(volumeLabel);
        window.add(volumeCalc);
        window.setBounds(100,100,500,300);
        window.setVisible(true);
    }

    public static double calculateVolume (int input){
        double toReturn = (4.0/3.0) * (3.14) * Math.pow  (input, 3);
        return toReturn;
    }

    public static void main(String[] args) {
        createGUI();    







    }
}