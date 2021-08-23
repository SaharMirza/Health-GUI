/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;

/**
 *
 * @author hp
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;

public class WaterIntake extends JFrame implements ActionListener {

    //labels for the goal
    private JLabel GoalLabel, Goal, minilabel1;
    
    //labels for achieved
    private JLabel WDrankLabel, Achieved, minilabel2;

    //buttons
    private JButton GoalIncrement, GoalDecrement, WDrankIncrement, WDrankDecrement,
            Analysis, Percentage, WCFoodsButton, Return, Exit;
    
    //setting values
    private static int GoalValue, AchievedValue = 0;
    public static int PLAIN_MESSAGE = -1;
    
    //setting format of the water percentage
    private static DecimalFormat df2 = new DecimalFormat("#.##");
  

    //Constructor
    public WaterIntake() {

        //creating panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);
        setTitle("WATER INTAKE");
        setBackground(Color.BLACK);

        //setting fonts
        Font a = new Font("Arial MT", Font.PLAIN, 20);
        Font b = new Font("Vrinda", Font.BOLD, 30);
        Font c = new Font("Vrinda", Font.ITALIC, 11);

        //Creating Goal Labels
        GoalLabel = new JLabel("GOAL");
        GoalLabel.setBounds(30, 5, 500, 100);
        GoalLabel.setFont(a);
        GoalLabel.setForeground(Color.WHITE);

        Goal = new JLabel("0");
        Goal.setBounds(120, 95, 165, 25);
        Goal.setFont(b);
        Goal.setForeground(Color.PINK);

        minilabel1 = new JLabel("glasses");
        minilabel1.setBounds(230, 95, 165, 25);
        minilabel1.setFont(c);
        minilabel1.setForeground(Color.WHITE);

        //Adding Goal Buttons
        GoalIncrement = new JButton(new ImageIcon("plussign.PNG"));
        GoalIncrement.setBounds(180, 95, 25, 25);
        GoalIncrement.setBackground(Color.DARK_GRAY);
        GoalIncrement.setBorder(null);
        GoalIncrement.addActionListener(this);
        GoalIncrement.setForeground(Color.WHITE);
        GoalIncrement.setContentAreaFilled(false);
        
        GoalDecrement = new JButton(new ImageIcon("negsign.PNG"));
        GoalDecrement.setBounds(50, 95, 25, 25);
        GoalDecrement.setBackground(Color.DARK_GRAY);
        GoalDecrement.setBorder(null);
        GoalDecrement.addActionListener(this);
        GoalDecrement.setForeground(Color.WHITE);

        //Creating Water Drank/ Achieved Labels
        WDrankLabel = new JLabel("WATER DRANK");
        WDrankLabel.setBounds(30, 120, 500, 100);
        WDrankLabel.setFont(a);
        WDrankLabel.setForeground(Color.WHITE);

        Achieved = new JLabel("0");
        Achieved.setBounds(120, 210, 165, 25);
        Achieved.setFont(b);
        Achieved.setForeground(Color.PINK);

        minilabel2 = new JLabel("glasses");
        minilabel2.setBounds(230, 210, 165, 25);
        minilabel2.setFont(c);
        minilabel2.setForeground(Color.WHITE);
        
        //Adding Water Drank Buttons
        WDrankIncrement = new JButton(new ImageIcon("plussign.PNG"));
        WDrankIncrement.setBounds(180, 210, 25, 25);
        WDrankIncrement.setBackground(Color.DARK_GRAY);
        WDrankIncrement.setBorder(null);
        WDrankIncrement.addActionListener(this);
        WDrankIncrement.setForeground(Color.WHITE);

        WDrankDecrement = new JButton(new ImageIcon("negsign.PNG"));
        WDrankDecrement.setBounds(50, 210, 25, 25);
        WDrankDecrement.setBackground(Color.DARK_GRAY);
        WDrankDecrement.setBorder(null);
        WDrankDecrement.addActionListener(this);
        WDrankDecrement.setForeground(Color.WHITE);

        /*Adding the Analysis Button, which will determine how much water 
        (in ml) you drank */
        Analysis = new JButton("Analyse");
        Analysis.setBounds(30, 270, 240, 20);
        Analysis.setBackground(Color.GRAY);
        Analysis.setBorder(null);
        Analysis.setForeground(Color.WHITE);
        Analysis.addActionListener(this);

        /*Adding the Percentage Button, which will determine what percent
        of water you drank */
        Percentage = new JButton("% of Water Drank");
        Percentage.setBounds(30, 300, 240, 20);
        Percentage.setBackground(Color.GRAY);
        Percentage.setBorder(null);
        Percentage.setForeground(Color.WHITE);
        Percentage.addActionListener(this);
        
        /*WCFoodButton will take you to another class which will display 
        a table containing water content in foods*/
        WCFoodsButton = new JButton("% of Water in Foods");
        WCFoodsButton.setBounds(30, 330, 240, 20);
        WCFoodsButton.setBackground(Color.GRAY);
        WCFoodsButton.setBorder(null);
        WCFoodsButton.setForeground(Color.WHITE);
        WCFoodsButton.addActionListener(this);
        
        //Return button will take you to the main panel
        Return = new JButton("BACK");
        Return.setBounds(20, 400, 120, 30);
        Return.setBackground(Color.GRAY);
        Return.setBorder(null);
        Return.addActionListener(this);
        
        //Exit Button will close the window
        Exit = new JButton("EXIT");
        Exit.setBounds(160, 400, 120, 30);
        Exit.setBackground(Color.GRAY);
        Exit.setBorder(null);
        Exit.addActionListener(this);

        //Adding all the labels and buttons to the panel
        panel.add(GoalLabel);
        panel.add(minilabel1);
        panel.add(Goal);
        panel.add(GoalIncrement);
        panel.add(GoalDecrement);
        panel.add(WDrankLabel);
        panel.add(minilabel2);
        panel.add(Achieved);
        panel.add(WDrankIncrement);
        panel.add(WDrankDecrement);
        panel.add(Analysis);
        panel.add(Percentage);
        panel.add(WCFoodsButton);
        panel.add(Return);
        panel.add(Exit);
        add(panel, BorderLayout.CENTER);

        //Customizing the frame
        this.setSize(340, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //Action Listener implemented
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == GoalIncrement) {
            GoalValue++;
            Goal.setText("" + GoalValue);

        }

        if (ae.getSource() == GoalDecrement) {
            GoalValue--;
            Goal.setText("" + GoalValue);

        }

        //converting the value in string to integer value
        int g = Integer.parseInt(Goal.getText());

        if (g == 1) {
            minilabel1.setText("glass");
        } else {
            minilabel1.setText("glasses");
        }

        //EXCEPTION HANDLING
        if (g < 0) {
            JOptionPane.showMessageDialog(this, "NUMBER OF GLASSES \nCAN NOT BE "
                    + "IN NEGATIVE", "ERROR", JOptionPane.ERROR_MESSAGE);
            Goal.setText("" + 0);
        }

        if (g == 0) {
            JOptionPane.showMessageDialog(this, "GOAL CAN NOT BE LEFT ZERO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        if (ae.getSource() == WDrankIncrement && g != 0) {
            AchievedValue++;
            Achieved.setText("" + AchievedValue);
        }

        if (ae.getSource() == WDrankDecrement && g != 0) {
            AchievedValue--;
            Achieved.setText("" + AchievedValue);
        }

        //converting the value in string to integer value
        int a = Integer.parseInt(Achieved.getText());

        if (a == 1) {
            minilabel2.setText("glass");
        } else {
            minilabel2.setText("glasses");
        }

        //EXCEPTION HANDLING
        if (a < 0) {
            JOptionPane.showMessageDialog(this, "NUMBER OF GLASSES \nCAN NOT BE "
                    + "IN NEGATIVE", "ERROR", JOptionPane.ERROR_MESSAGE);
            Achieved.setText("" + 0);
        }

        if (ae.getSource() == Analysis) {
            if (a < g) {
                JOptionPane.showMessageDialog(this, "YOU DRANK " + (a * 250) + " ml OUT OF "
                        + (g * 250) + " ml. \nGOAL NOT REACHED", "ANALYSIS", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "YOU DRANK " + (a * 250) + " ml OUT OF "
                        + (g * 250) + " ml. \nGOAL REACHED", "ANALYSIS", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if (ae.getSource() == Percentage) {

            double percentageWDrank = ((double) (a) / g) * 100;
            JOptionPane.showMessageDialog(this, "PERCENTAGE OF WATER DRANK PER DAY: \n"
                    + df2.format(percentageWDrank) + "%", "ANALYSIS", JOptionPane.PLAIN_MESSAGE);
        }

        //Opens new frame
        if (ae.getSource() == WCFoodsButton) {
            
            this.setVisible(false);
            WaterContentinFoods WCF = new WaterContentinFoods();
        }
        
        if (ae.getSource() == Return){
            
            this.toBack();
            setVisible(false);
            new OOPProject().toFront();
            
        }
        
        if (ae.getSource() == Exit){
            setVisible(false);
        }
    }

   
}

