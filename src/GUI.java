import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI{


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
                double input = 0;

                try {
                    input = Double.parseDouble(volumeInput.getText());
                    double result = calculateVolume(input);

                    resultWindow(result, "YOUR VOLUME");


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
        JLabel xPrompt = new JLabel("SIDE A");
        JTextField xInput = new JTextField(8);

        JLabel yPrompt = new JLabel("SIDE B");
        JTextField yInput = new JTextField(8);

        JLabel zPrompt = new JLabel("HYPOTENUSE");
        JTextField zInput = new JTextField(8);

        inputWindow.add(xPrompt);
        inputWindow.add(xInput);

        inputWindow.add(yPrompt);
        inputWindow.add(yInput);

        inputWindow.add(zPrompt);
        inputWindow.add(zInput);


        JButton triangleButton = new JButton("Go");

        triangleButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                errorT.setText("");
                try {


                    String xValue = xInput.getText();
                    String yValue = yInput.getText();
                    String zValue = zInput.getText();

                    if (xValue.equals("x")){
                        double result = Math.sqrt(Math.pow(Double.parseDouble(zValue), 2) - Math.pow(Double.parseDouble(yValue), 2));

                        resultWindow(result, "YOUR MISSING SIDE");


                    }
                    else if (yValue.equals("x")){
                        double result = Math.sqrt(Math.pow(Double.parseDouble(zValue), 2) - Math.pow(Double.parseDouble(xValue), 2));

                        resultWindow(result, "YOUR MISSING SIDE");


                    } else if (zValue.equals("x")){
                        double result = Math.sqrt(Math.pow(Double.parseDouble(xValue), 2) + Math.pow(Double.parseDouble(yValue), 2));

                        resultWindow(result, "YOUR MISSING SIDE");

                    } else {
                        errorT.setText( "Error. Please input one side with x");
                    }



                } catch (Exception f) {
                    errorT.setText( "Error. Please input numbers");

                }

            }
        });
        triangleCalc.add(inputWindow);
        triangleCalc.add(triangleButton);
        triangleCalc.add(errorT);

        return triangleCalc;
    }

    public static JPanel interestCalc(){
        JLabel errorI = new JLabel();

        JPanel interestCalc = new JPanel();
        interestCalc.setLayout(new FlowLayout());
        JPanel inputWindow = new JPanel();

        inputWindow.setLayout(new GridLayout(3, 1));
        JLabel principalPrompt = new JLabel("PRINCIPAL");
        JTextField principalInput = new JTextField(8);

        JLabel interestPrompt = new JLabel("INTEREST (%)");
        JTextField interestInput = new JTextField(8);

        JLabel timePrompt = new JLabel("TIME (yrs)");
        JTextField timeInput = new JTextField(8);

        inputWindow.add(principalPrompt);
        inputWindow.add(principalInput);

        inputWindow.add(interestPrompt);
        inputWindow.add(interestInput);

        inputWindow.add(timePrompt);
        inputWindow.add(timeInput);

        JButton interestButton = new JButton("Go");

        interestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorI.setText("");


                try {
                    double principalValue =  Double.parseDouble(principalInput.getText());
                    double interestValue =  (Double.parseDouble(interestInput.getText()) / 100);
                    double timeValue =  Double.parseDouble(timeInput.getText());
                    double rt = interestValue * timeValue;
                    double euler = 2.71828;

                    System.out.println(principalValue);
                    System.out.println(interestValue);



                    System.out.println(timeValue);

                    double result = principalValue *  Math.pow(euler, rt);

                    System.out.println(result);

                    resultWindow(result, "YOUR TOTAL AMOUNT AFTER " + timeValue + " YEARS");

                } catch (Exception f){
                    errorI.setText("Error. Please input numbers.");
                }
            }
        });

        interestCalc.add(inputWindow);
        interestCalc.add(interestButton);
        interestCalc.add(errorI);

        return interestCalc;
    }

    public static void createGUI(){

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
        JPanel compoundLabel = new JPanel();
        compoundLabel.setLayout(new FlowLayout());
        JLabel compound = new JLabel("CALCULATE CONTINUOUSLY COMPOUND INTEREST");
        compoundLabel.add(compound);


        window.add(volumeLabel);
        window.add(volumeCalc());

        window.add(triangleLabel);
        window.add(triangleCalc());

        window.add(compoundLabel);
        window.add(interestCalc());

        window.setBounds(100,100,750,750);
        window.setVisible(true);
    }

    public static void resultWindow(double result, String title){
        JFrame resultWindow = new JFrame(title);
        resultWindow.setLayout(new FlowLayout());
        resultWindow.setBounds(100,100,500,150);
        resultWindow.add(new JLabel(String.valueOf(result)));
        resultWindow.setResizable(false);
        resultWindow.setVisible(true);
    }

    public static double calculateVolume (double input){
        double toReturn = (4.0/3.0) * (3.14) * Math.pow(input, 3);
        return toReturn;
    }

    public static void main(String[] args) {
        createGUI();    







    }
}