import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI{

    private static JTextField derivativeTextfield = new JTextField(16);
    private static JTextField integralTextfield = new JTextField(16);
    private static JTextField convertTextfield = new JTextField(16);


    public static JPanel volumeCalc(){
        JLabel errorV = new JLabel();

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

        return volumeCalc;
    }

    public static JPanel triangleCalc(){
        JLabel errorT = new JLabel();

        JPanel triangleCalc = new JPanel();
        triangleCalc.setLayout(new FlowLayout());
        JPanel inputWindow = new JPanel();

        inputWindow.setLayout(new GridLayout(3,1));
        JLabel xPrompt = new JLabel("ANGLE X");
        JTextField xInput = new JTextField(8);

        JLabel yInput = new JLabel("ANGLE Y");
        JTextField yPrompt = new JTextField(8);

        JLabel zInput = new JLabel("ANGLE Z");
        JTextField zPrompt = new JTextField(8);

        inputWindow.add(xPrompt);
        inputWindow.add(xInput);

        inputWindow.add(yInput);
        inputWindow.add(yPrompt);

        inputWindow.add(zInput);
        inputWindow.add(zPrompt);


        JButton triangleButton = new JButton("Go");

        triangleButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                errorT.setText("");
                try {


                    String xValue = xInput.getText();
                    String yValue = yInput.getText();
                    String zValue = zInput.getText();

                    if (xValue.equals("x") && !(yValue.equals("x") || zValue.equals("x"))){

                    }
                    else if (yValue.equals("x") && !(xValue.equals("x") || zValue.equals("x"))){

                    } else if (zValue.equals("x") && !(xValue.equals("x") || yValue.equals("x"))){

                    } else {
                        errorT.setText( "Error. Please input a number");
                    }

                    System.out.println("works");
//                    input = Integer.parseInt(volumeInput.getText());
//                    double result = calculateVolume(input);
//
//                    JFrame resultWindow = new JFrame("YOUR VOLUME");
//                    resultWindow.setLayout(new FlowLayout());
//                    resultWindow.setBounds(100,100,300,150);
//                    resultWindow.add(new JLabel(String.valueOf(result)));
//                    resultWindow.setResizable(false);
//                    resultWindow.setVisible(true);


                } catch (Exception f) {
                    errorT.setText( "Error. Please input a number");

                }

            }
        });
        triangleCalc.add(inputWindow);
        triangleCalc.add(triangleButton);
        triangleCalc.add(errorT);

        return triangleCalc;
    }


    public static void createGUI(){

        JLabel errorI = new JLabel();

        // create window
        JFrame window = new JFrame("Advanced Calculator");
        window.setLayout(new GridLayout(6,1));

        // volume section
        JPanel volumeLabel = new JPanel();
        volumeLabel.setLayout(new FlowLayout());
        JLabel volume = new JLabel("CALCULATE VOLUME OF A SPHERE");
        volumeLabel.add(volume);



        // find missing angle
        JPanel triangleLabel = new JPanel();
        triangleLabel.setLayout(new FlowLayout());
        JLabel triangle = new JLabel("CALCULATE MISSING TRIANGLE SIDE | input x for the side you want to solve for");
        triangleLabel.add(triangle);





        // find compound interest

        window.add(volumeLabel);
        window.add(volumeCalc());

        window.add(triangleLabel);
        window.add(triangleCalc());

        window.setBounds(100,100,500,500);
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