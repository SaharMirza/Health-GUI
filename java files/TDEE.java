/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class TDEE extends JFrame implements ActionListener {

    private int Result;
    private String s, x;
    private JLabel TDEEL, LifeStyleLabel, SedentaryL, LActiveL, ModerateL, VActiveL,
            EActiveL, WITDEE, HITDEEU, Tell = new JLabel();
    private JRadioButton Sedentary, LActive, Moderate, VActive, EActive;
    private JButton back, Exit;
    private final ImageIcon Icon;

    public TDEE(int BMR) {
        this.Result = BMR;
        x = Integer.toString(Result);

        JPanel panel = new JPanel();
        setTitle("TDEE Calculator");
        setBackground(Color.BLACK);

        //////////////////////Defining BMR as JLabel\\\\\\\\\\\\\\\\\\\\\
        WITDEE = new JLabel("<html><font size=\"+2\">What Is TDEE?</font><br/>"
                + "TDEE or Total Daily Energy Expenditure"
                + " is the total number of calories your body will burn in one "
                + "day depending on your activity level.", JLabel.CENTER);

        /////////////////////Telling how is BMR used uing JLabel\\\\\\\\\\\\\\\
        HITDEEU = new JLabel("<html><font size=\"+2\">How Is TDEE Used?</font>"
                + "<br/>TDEE in conjuction with your Daily Calorie Intake are "
                + "used to help meet dietary goals."
                + "<br/>If your TDEE is greater than your Daily Calorie Intake, you will Lose Weight."
                + "<br/>If your TDEE is less than your Daily Calorie Intake, you will Gain Weight."
                + "<br/>If your TDEE is equal to your Daily Calorie Intake, you will Mantain Your Weight."
                + "<br/>To calculate TDEE you need to tell your activity level(Lifestyle)."
                + "</html>", JLabel.CENTER);

        /////////////LifeStyle Label and its options\\\\\\\\\\\\\\\\
        LifeStyleLabel = new JLabel("LIFESTYLE");
        SedentaryL = new JLabel("<html><font size=\"+1\">SEDENTARY</font>"
                + "<br/>Little or no Exercise</html>");
        LActiveL = new JLabel("<html><font size=\"+1\">LIGHTLY ACTIVE</font>"
                + "<br/>Light exercise/sports 1-3 days/wk</html>");
        ModerateL = new JLabel("<html><font size=\"+1\">MODERATELY ACTIVE</font>"
                + "<br/>Moderate exercise/sports3-5 days/wk</html>");
        VActiveL = new JLabel("<html><font size=\"+1\">VERY ACTIVE</font>"
                + "<br/>Hard exercise/sports 6-7 days/wk</html>");
        EActiveL = new JLabel("<html><font size=\"+1\">EXTRA ACTIVE</font>"
                + "<br/>Beast Mode-Physical Job/2X day training</html>");

        /////////////Calculated TDEE Result\\\\\\\\\\\\\\
        Icon = new ImageIcon("bmr.PNG");

        TDEEL = new JLabel("<html><span class=<font size='6'> TDEE </font></span>"
                + 0 + "<font size='6'> CALORIES</font></html>", Icon, JLabel.CENTER);

        ///////////set bouns of labels and font setting of labels \\\\\\\\\\\\\\       
        WITDEE.setBounds(30, 20, 430, 90);
        HITDEEU.setBounds(30, 50, 430, 340);
        TDEEL.setBounds(0, 415, 530, 80);
        LifeStyleLabel.setBounds(40, 345, 130, 20);

        SedentaryL.setBounds(155, 365, 140, 35);
        LActiveL.setBounds(200, 365, 200, 35);
        ModerateL.setBounds(235, 355, 220, 55);
        VActiveL.setBounds(280, 365, 200, 35);
        EActiveL.setBounds(325, 360, 220, 55);
        Tell.setBounds(40, 485, 460, 60);

        LifeStyleLabel.setForeground(Color.WHITE);
        SedentaryL.setForeground(Color.GRAY);
        LActiveL.setForeground(Color.GRAY);
        ModerateL.setForeground(Color.GRAY);
        VActiveL.setForeground(Color.GRAY);
        EActiveL.setForeground(Color.GRAY);
        WITDEE.setForeground(Color.WHITE);
        HITDEEU.setForeground(Color.WHITE);
        TDEEL.setForeground(Color.WHITE);
        Tell.setForeground(Color.WHITE);

        TDEEL.setBackground(new Color(72, 61, 112));
        Font f = new Font("Calbiri (Body)", Font.PLAIN, 14);
        WITDEE.setFont(f);
        HITDEEU.setFont(f);
        Font a = new Font("Calbiri (Body)", Font.BOLD, 16);
        LifeStyleLabel.setFont(a);
        Tell.setFont(a);
        Font r = new Font("Calbiri (Body)", Font.BOLD, 34);
        TDEEL.setFont(r);

        TDEEL.setOpaque(true);

        //////////Adding Labels to Frame\\\\\\\\\\\\\\\
        add(HITDEEU);
        add(WITDEE);

        add(LifeStyleLabel);
        add(SedentaryL);
        add(LActiveL);
        add(ModerateL);
        add(VActiveL);
        add(EActiveL);
        add(Tell);

        ////////Setting LifeStyle Labels false initially\\\\\\
        LActiveL.setVisible(false);
        SedentaryL.setVisible(false);
        ModerateL.setVisible(false);
        VActiveL.setVisible(false);
        EActiveL.setVisible(false);

        //////////////Radio Button Initalization\\\\\\\\\\\\\\        
        Sedentary = new JRadioButton();
        LActive = new JRadioButton();
        Moderate = new JRadioButton();
        VActive = new JRadioButton();
        EActive = new JRadioButton();

        /////////////Radio Button Color and bound setting\\\\\\\\\\\\\
        Sedentary.setBackground(Color.DARK_GRAY);
        LActive.setBackground(Color.DARK_GRAY);
        Moderate.setBackground(Color.DARK_GRAY);
        VActive.setBackground(Color.DARK_GRAY);
        EActive.setBackground(Color.DARK_GRAY);

        //////Adding RadioButtons to panel\\\\\\\\\
        Sedentary.setBounds(155, 348, 17, 14);
        Sedentary.setOpaque(false);
        LActive.setBounds(195, 348, 17, 14);
        Moderate.setBounds(235, 348, 17, 14);
        VActive.setBounds(280, 348, 17, 14);
        EActive.setBounds(325, 348, 17, 14);

        //////////Adding Actionlistener to Radio Buttons\\\\\\\
        Sedentary.addActionListener(this);
        LActive.addActionListener(this);
        Moderate.addActionListener(this);
        VActive.addActionListener(this);
        EActive.addActionListener(this);

        //////////Adding JRadioButtons to panel\\\\\\\\\\
        add(Sedentary);
        add(LActive);
        add(Moderate);
        add(VActive);
        add(EActive);

        /////////Grouping JRadioButtons\\\\\\\\\\\
        ButtonGroup bg = new ButtonGroup();
        bg.add(Sedentary);
        bg.add(LActive);
        bg.add(Moderate);
        bg.add(VActive);
        bg.add(EActive);

        ////////////////////Adding Exit And Back buttons\\\\\\\\
        Exit = new JButton("EXIT");
        back = new JButton("BACK");

        back.setBounds(40, 560, 200, 30);
        Exit.setBounds(260, 560, 200, 30);
        Font s = new Font("Calbiri (Body)", Font.BOLD, 14);
        Exit.setFont(s);
        back.setFont(s);

        Exit.setBackground(Color.GRAY);
        back.setBackground(Color.GRAY);

        Exit.addActionListener(this);
        back.addActionListener(this);

        ButtonGroup b = new ButtonGroup();
        bg.add(Exit);
        bg.add(back);

        add(Exit);
        add(back);

        add(TDEEL);///adding Tdee result label

        panel.setBackground(Color.darkGray);
        this.setSize(550, 660);
        add(panel);
        panel.setLayout(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == Sedentary) {
            ModerateL.setVisible(false);
            EActiveL.setVisible(false);
            VActiveL.setVisible(false);
            LActiveL.setVisible(false);
            SedentaryL.setVisible(true);
            //////Calculating TDEE if Sedentary is choosen\\\\\\\
            double SResult = 1.2 * Result;
            int value = (int) SResult;//converting doble value of TDEE to int 
            s = Integer.toString(value);///converting value to string to show on label
            refreshLabel();
        }

        if (ae.getSource() == LActive) {
            SedentaryL.setVisible(false);
            ModerateL.setVisible(false);
            EActiveL.setVisible(false);
            VActiveL.setVisible(false);
            LActiveL.setVisible(true);
            //////Calculating TDEE if Light Activity is choosen\\\\\\\
            double LAR = 1.375 * Result;
            int value = (int) LAR;//converting doble value of TDEE to int
            s = Integer.toString(value);//converting value to string to show on label
            refreshLabel();
        }

        if (ae.getSource() == Moderate) {
            SedentaryL.setVisible(false);
            LActiveL.setVisible(false);
            EActiveL.setVisible(false);
            VActiveL.setVisible(false);
            ModerateL.setVisible(true);
            //////Calculating TDEE if Mederate is choosen\\\\\\\
            double MR = 1.55 * Result;
            int value = (int) MR;//converting doble value of TDEE to int
            s = Integer.toString(value);//converting value to string to show on label
            refreshLabel();
        }

        if (ae.getSource() == VActive) {
            SedentaryL.setVisible(false);
            LActiveL.setVisible(false);
            ModerateL.setVisible(false);
            EActiveL.setVisible(false);
            VActiveL.setVisible(true);
            //////Calculating TDEE if Very Active is choosen\\\\\\\
            double VAR = 1.725 * Result;
            int value = (int) VAR;//converting doble value of TDEE to int
            s = Integer.toString(value);//converting value to string to show on label
            refreshLabel();
        }

        if (ae.getSource() == EActive) {
            SedentaryL.setVisible(false);
            LActiveL.setVisible(false);
            ModerateL.setVisible(false);
            EActiveL.setVisible(true);
            VActiveL.setVisible(false);
            //////Calculating TDEE if Extra Active is choosen\\\\\\\
            double EAR = 1.9 * Result;
            int value = (int) EAR;//converting doble value of TDEE to int
            s = Integer.toString(value);//converting value to string to show on label
            refreshLabel();
        }
        ////////Writing BMR,TDEE in text file\\\\\\\\\\\
        try {
            File Bfile = new File("BMR.txt");
            FileWriter writer = new FileWriter(Bfile);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("BMR =" + x);
            bw.newLine();
            bw.write("TDEE = " + s);

            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        /////////if Exit Button clicked closes TDEE calculator\\\\\\\
        if (ae.getSource() == Exit) {
            this.setVisible(false);

        }
        ////////if Back Button Clicked goes back to BMR Calculator\\\\\\\
        if (ae.getSource() == back) {
            this.setVisible(false);

            try {
                BMR BMR = new BMR();
            } catch (FileNotFoundException ex) {
                System.out.print("Exception");
            }

        }

    }

    private void refreshLabel() {
        ///////To change TDEE value according to chossen lifestyle\\\\\\\
        TDEEL.setText("<html><style>\n" + "\n"
                + ".small_font{\n" + "	font-size: 20pt;\n" + "}\n" + "\n"
                + ".large_font{\n" + "	font-size: 30pt;\n" + "  }\n" + "\n"
                + "</style>\n"
                + "</head>\n" + "\n"
                + "<body>\n" + "\n"
                + "<span class=\"small_font\">\n" + "TDEE \n"
                + "</span>\n" + "<span class=\"large_font\">\n"
                + s
                + "</span>" + "\n" + "<span class=\"small_font\">\n"
                + "CALORIES"
                + "</span></html>");
        Tell.setText("You Need To Eat " + s + " Calories To Stay The Same Weight.");

    }

}
