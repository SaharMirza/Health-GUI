/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class BMR extends JFrame implements ActionListener {

    final private int SMan = 66;
    final private int SWoman = 655, BMR;
    private double BM;
    int age;
    double weight, height;
    private JLabel BMRL, WISBMR, UOFBMR;
    private final ImageIcon Icon;
    private JButton Exit, TDEE, Back;

    public BMR() throws FileNotFoundException {

        File file = new File("datafile.txt");
        Scanner scan = new Scanner(file);

        //////// Reading Age from Textfile\\\\\\\\\\\\       
        scan.nextLine();
        String AgeFile = "";
        AgeFile = AgeFile.concat(scan.nextLine());
        String Age = AgeFile.substring(15);
        age = Integer.parseInt(Age);

        //////// Reading Gender from Textfile\\\\\\\\\\\\
        String GenderFile = "";
        GenderFile = GenderFile.concat(scan.nextLine());
        String Gender = GenderFile.substring(8);

        //////// Reading Weight from Textfile\\\\\\\\\\\\             
        String WeightFile = "";
        WeightFile = WeightFile.concat(scan.nextLine());
        String Weight = WeightFile.substring(15);
        weight = Double.parseDouble(Weight);

        //////// Reading Height from Textfile\\\\\\\\\\\\             
        String HeightFile = "";
        HeightFile = HeightFile.concat(scan.nextLine());
        String Height = HeightFile.substring(15);
        height = Double.parseDouble(Height);

        ////////Calculating BMR\\\\\\\\\\\\\\\       
        if (Gender.equals("Female")) {
            BM = 9.6 * weight + 1.8 * height - 4.7 * age + SWoman;
        }
        if (Gender.equals("Male")) {
            BM = 13.75 * weight + 5 * height - 6.76 * age + SMan;
        }
        BMR = (int) BM;

        //////////Creating Panel\\\\\\\\\\\\\
        JPanel panel = new JPanel();
        setTitle("BMR Calculator");
        setBackground(Color.BLACK);

        ///////Setting Title and background for BMR Frame\\\\\\\\\\\
        setTitle("BMR CALCULATOR");
        setBackground(Color.BLACK);

        /////////Add Calculated BMR to panel using JLabel\\\\\\\\\\\ 
        Icon = new ImageIcon("bmr.PNG");

        BMRL = new JLabel("<html><span class=<font size='6'> BMR </font></span>"
                + BMR + "<font size='6'> CALORIES</font></html>", Icon, JLabel.CENTER);
        /////////////////////////Defining BMR as JLabel\\\\\\\\\\\\\\\\\\\\\\\
        WISBMR = new JLabel("<html><font size=\"+2\">What Is BMR?</font><br/>Your "
                + "Basal Matabolic Rate(BMR)"
                + " represents the minimal amount of energy(calories)"
                + " your body needs to stay alive. It does not include calories "
                + "burned while performing some activity.</html>", JLabel.CENTER);

        /////////////////////Telling how is BMR used uing JLabel\\\\\\\\\\\\\\\
        UOFBMR = new JLabel("<html><font size=\"+2\">How Is BMR Used?</font>"
                + "<br/>BMR is the starting point of information you will need "
                + "to formulaically lose weight."
                + "<br/>Starting with your BMR as base line, add in all your "
                + "additional burned calories(based on how active you were) to "
                + "come up with your TDEE(totatl daily energy expenditure)."
                + "<br/>If your TDEE matches your Daily Calorie intake you will"
                + " maintain your weight. If you increase your TDEE over your daily "
                + "calorie intake you will lose weight."
                + "For most people, burning 3,500 calories more than you take in "
                + "will allow you to lose one pound of fat. "
                + "</html>", JLabel.CENTER);

        ////////////Setting location and size of labels\\\\\\\\\\\\\\\
        BMRL.setLocation(0, 50);
        BMRL.setSize(485, 80);
        BMRL.setForeground(Color.WHITE);
        BMRL.setBackground(new Color(72, 61, 112));
        Font r = new Font("Calbiri (Body)", Font.BOLD, 34);
        BMRL.setFont(r);
        BMRL.setOpaque(true);

        WISBMR.setLocation(20, 135);
        WISBMR.setSize(430, 90);
        WISBMR.setForeground(Color.WHITE);
        Font f = new Font("Calbiri (Body)", Font.PLAIN, 14);
        WISBMR.setFont(f);

        UOFBMR.setLocation(20, 190);
        UOFBMR.setSize(430, 300);
        UOFBMR.setForeground(Color.WHITE);
        UOFBMR.setFont(f);

        ////////////Adding labels to panel\\\\\\\\\\\\\\\\\\\
        add(BMRL);
        add(WISBMR);
        add(UOFBMR);

        ////////////////////Adding Exit And calculate tdee buttons\\\\\\\\
        Exit = new JButton("EXIT");
        TDEE = new JButton("Calculate My TDEE");
        Back = new JButton("BACK");

        Exit.setBounds(350, 480, 90, 30);
        Back.setBounds(20, 480, 90, 30);
        TDEE.setBounds(130, 480, 200, 30);
        Font s = new Font("Calbiri (Body)", Font.BOLD, 14);
        Exit.setFont(s);
        TDEE.setFont(s);
        Back.setFont(s);

        Exit.setBackground(Color.GRAY);
        Back.setBackground(Color.GRAY);
        TDEE.setBackground(Color.GRAY);

        Back.addActionListener(this);
        Exit.addActionListener(this);
        TDEE.addActionListener(this);

        ButtonGroup bg = new ButtonGroup();
        bg.add(Back);
        bg.add(Exit);
        bg.add(TDEE);

        add(Back);
        add(Exit);
        add(TDEE);

        ////////////Formating of panel(bg colour,size,borders)\\\\\\\\\\\\\\
        panel.setBackground(Color.darkGray);
        this.setSize(500, 600);
        add(panel);
        panel.setLayout(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        /////////////Writing Calculate BMR to text file\\\\\\\\\\        
        try {
            File Bfile = new File("BMR.txt");
            FileWriter writer = new FileWriter(Bfile);
            BufferedWriter bw = new BufferedWriter(writer);
            String b = Integer.toString(BMR);
            bw.write("BMR = " + b);

            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //////Condition to move to TDEE Frame if Calculate my TDEE clicked\\\\\
        if (ae.getSource() == TDEE) {

            this.setVisible(false);

            TDEE TDEE = new TDEE(BMR);

        }
        //////Condition to exit Frame\\\\\\\
        if (ae.getSource() == Exit) {
            this.setVisible(false);

        }
        ////////if Back Button Clicked goes back to BMR Calculator\\\\\\\
        if (ae.getSource() == Back) {
            this.toBack();
            this.setVisible(false);

            new OOPProject().toFront();
            //new OOPProject().setState(java.awt.Frame.NORMAL);

        }
    }

}
