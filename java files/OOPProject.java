/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.io.*;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OOPProject extends JFrame implements ActionListener {

    //declaring variables
    private JTextField NameText, AgeText, WeightText, HeightText;
    private JLabel labels, Namelabels, Agelabel, Genderlabel, Weightlabel,
            Heightlabel, BloodGrouplabel, MenuLabel, FemaleLabel, MaleLabel;
    private JButton BBMR, BBMI, BWaterIntake, BSleepSchedule, BUpdate;
    private JRadioButton Female, Male;
    private JComboBox BloodGroup;

    public OOPProject() {

        //creating a new JPanel, setting color and setting title
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        add(panel);
        panel.setLayout(null);
        setTitle("Health GUI");
        setBackground(Color.BLACK);

        //initalizing Labels
        labels = new JLabel("Enter Your Personal Information");
        Namelabels = new JLabel("NAME");
        Agelabel = new JLabel("AGE (years)");
        Genderlabel = new JLabel("GENDER");
        FemaleLabel = new JLabel("FEMALE");
        MaleLabel = new JLabel("MALE");
        Weightlabel = new JLabel("WEIGHT (kg)");
        Heightlabel = new JLabel("HEIGHT (cm)");
        BloodGrouplabel = new JLabel("BLOODGROUP");
        MenuLabel = new JLabel("MENU");

        //Locaion and size setting of labels
        labels.setBounds(27, 1, 500, 100);
        Namelabels.setBounds(27, 100, 86, 14);
        Agelabel.setBounds(27, 150, 86, 14);
        Genderlabel.setBounds(27, 200, 86, 14);
        FemaleLabel.setBounds(145, 33, 350, 350);
        MaleLabel.setBounds(245, 33, 350, 350);
        Weightlabel.setBounds(27, 250, 86, 14);
        Heightlabel.setBounds(27, 300, 86, 14);
        BloodGrouplabel.setBounds(27, 350, 86, 14);
        MenuLabel.setBounds(27, 420, 86, 14);

        //Setting Font Type,Colour,Size
        Font f = new Font("Vrinda", Font.BOLD, 18);
        labels.setFont(f);
        labels.setForeground(Color.WHITE);

        Namelabels.setForeground(Color.WHITE);
        Agelabel.setForeground(Color.WHITE);
        Genderlabel.setForeground(Color.WHITE);
        FemaleLabel.setForeground(Color.WHITE);
        MaleLabel.setForeground(Color.WHITE);
        Weightlabel.setForeground(Color.WHITE);
        Heightlabel.setForeground(Color.WHITE);
        BloodGrouplabel.setForeground(Color.WHITE);

        Font j = new Font("Vrinda", Font.BOLD, 18);
        MenuLabel.setFont(j);
        MenuLabel.setForeground(Color.WHITE);

        //Adding Labels to panel
        panel.add(labels);
        panel.add(Namelabels);
        panel.add(Agelabel);
        panel.add(Genderlabel);
        panel.add(FemaleLabel);
        panel.add(MaleLabel);
        panel.add(Weightlabel);
        panel.add(Heightlabel);
        panel.add(BloodGrouplabel);
        panel.add(MenuLabel);

        //Adding TextFields
        NameText = new JTextField();
        AgeText = new JTextField();
        WeightText = new JTextField();
        HeightText = new JTextField();

        //Setting Bounds of TextFields
        NameText.setBounds(120, 95, 165, 25);
        NameText.setBorder(null);

        AgeText.setBounds(120, 145, 165, 25);
        AgeText.setBorder(null);

        WeightText.setBounds(120, 245, 165, 25);
        WeightText.setBorder(null);

        HeightText.setBounds(120, 295, 165, 25);
        HeightText.setBorder(null);

        NameText.setHorizontalAlignment(JTextField.CENTER);
        AgeText.setHorizontalAlignment(JTextField.CENTER);
        WeightText.setHorizontalAlignment(JTextField.CENTER);
        HeightText.setHorizontalAlignment(JTextField.CENTER);
        NameText.setCaretColor(Color.WHITE);
        AgeText.setCaretColor(Color.WHITE);
        WeightText.setCaretColor(Color.WHITE);
        HeightText.setCaretColor(Color.WHITE);
        //Setting Colour of TextField to gray and it's Text to White
        NameText.setBackground(Color.GRAY);
        NameText.setForeground(Color.WHITE);
        AgeText.setBackground(Color.GRAY);
        AgeText.setForeground(Color.WHITE);
        WeightText.setBackground(Color.GRAY);
        WeightText.setForeground(Color.WHITE);
        HeightText.setBackground(Color.GRAY);
        HeightText.setForeground(Color.WHITE);

        //Adding TextFields to panel
        panel.add(NameText);
        panel.add(AgeText);
        panel.add(WeightText);
        panel.add(HeightText);

        //Adding JCombobox(dropdown) for BloodGroup
        String bloodtype[] = {"A+ ", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        BloodGroup = new JComboBox(bloodtype);
        BloodGroup.setLocation(120, 345);
        BloodGroup.setSize(90, 25);
        BloodGroup.setVisible(true);
        panel.add(BloodGroup);
        BloodGroup.addActionListener(this);

        //Initalizing Buttons
        BUpdate = new JButton("Update");
        BBMR = new JButton("BMR Calculator");
        BBMI = new JButton("BMI Calculator");
        BWaterIntake = new JButton("WaterIntake");
        BSleepSchedule = new JButton("Sleep Schedule");

        //Setting bounds and BG color for buttons
        BUpdate.setBounds(27, 390, 150, 20);
        BBMR.setBounds(27, 450, 150, 20);
        BBMI.setBounds(27, 500, 150, 20);
        BWaterIntake.setBounds(180, 450, 150, 20);
        BSleepSchedule.setBounds(180, 500, 150, 20);

        BUpdate.setBackground(Color.GRAY);
        BBMR.setBackground(Color.GRAY);
        BBMI.setBackground(Color.GRAY);
        BWaterIntake.setBackground(Color.GRAY);
        BSleepSchedule.setBackground(Color.GRAY);

        //Adding actionlistener to buttons to make sure they're functional
        BUpdate.addActionListener(this);
        BBMR.addActionListener(this);
        BBMI.addActionListener(this);
        BWaterIntake.addActionListener(this);
        BSleepSchedule.addActionListener(this);

        //Adding radio buttons for gender and setting image 
        Female = new JRadioButton();//Adding image to Button        
        Male = new JRadioButton();//Adding image to Button
        //addihng actionlistener to the radio buttons for functionality
        Female.addActionListener(this);
        Male.addActionListener(this);

        //Adding RadioButtons to panel
        panel.add(Female);
        panel.add(Male);

        //Setting TextColor, Size,Location, and Background color of Radio Button
        Female.setForeground(Color.WHITE);
        Male.setForeground(Color.WHITE);

        Female.setBackground(Color.DARK_GRAY);
        Male.setBackground(Color.DARK_GRAY);

        Female.setSize(25, 14);
        Male.setSize(25, 14);
        Female.setLocation(120, 200);
        Male.setLocation(220, 200);

        //Grouping Radio Buttons
        ButtonGroup bg = new ButtonGroup();
        bg.add(Female);
        bg.add(Male);

        //Adding Buttons to panel
        panel.add(BBMR);
        panel.add(BBMI);
        panel.add(BSleepSchedule);
        panel.add(BWaterIntake);
        panel.add(BUpdate);

        add(panel, BorderLayout.CENTER);
        this.setSize(400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            //creating file and making sure input given in JTextField is saved 
            //in the file
            File file = new File("datafile.txt");
            FileWriter writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);
            //saving name and age in file
            bw.write("Name: " + NameText.getText());
            bw.newLine();
            bw.write("Age(in years): " + AgeText.getText());
            bw.newLine();

            //conditions to makesure correct selectionis savedin file
            if (Female.isSelected()) {
                bw.write("Gender: Female");
            } else {
                bw.write("Gender: Male");
            }
            //saving weight, height and age in file
            bw.newLine();
            bw.write("Weight(in kg): " + WeightText.getText());
            bw.newLine();
            bw.write("Height(in cm): " + HeightText.getText());
            bw.newLine();

            String s = String.valueOf(BloodGroup.getSelectedItem());
            bw.write("Blood Group: " + s);

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (ae.getSource() == BUpdate) {
            boolean successfulupdate = true;
            {
                //showing error message in case user doesnot input letters
                String Name = NameText.getText(); //perform your operation
                for (int i = 0; i < Name.length(); i++) {
                    char ch = Name.charAt(i);
                    if (!(Character.isLetter(ch)) && !(ch == ' ')) {
                        successfulupdate = false;

                        JOptionPane.showMessageDialog(this, "Name Cannot Contain "
                                + "Numbers. \n Please Enter Your Name Again.",
                                "Input Error", JOptionPane.ERROR_MESSAGE);
                        break;

                    }

                }
                //showing error message in case user leaves fields blank
                if (Name.equals("")) {
                    successfulupdate = false;

                    JOptionPane.showMessageDialog(this, "Please Enter Name",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                if (AgeText.getText().equals("")) {
                    successfulupdate = false;

                    JOptionPane.showMessageDialog(this, "Please Enter Age",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                if (WeightText.getText().equals("")) {
                    successfulupdate = false;

                    JOptionPane.showMessageDialog(this, "Please Enter Weight",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                if (HeightText.getText().equals("")) {
                    successfulupdate = false;

                    JOptionPane.showMessageDialog(this, "Please Enter Height",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }

                if (!Female.isSelected() && !Male.isSelected()) {
                    successfulupdate = false;
                    JOptionPane.showMessageDialog(this, "Please Select Gender",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }

                try {
                    //make sure integer value entered for age
                    int Age = Integer.parseInt(AgeText.getText());

                } catch (NumberFormatException ex) {
                    successfulupdate = false;

                    JOptionPane.showMessageDialog(this, "Integer value expected."
                            + " Please write Age again ", "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                
                    //make sure double value entered for weight and height
                    double Weight = Double.parseDouble(WeightText.getText());
                    double Height = Double.parseDouble(HeightText.getText());

                

            }
            //showing message depending on whether user has inputted correctly
            if (successfulupdate == true) {
                JOptionPane.showMessageDialog(this, "SUCCESSFUL", " Update",
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, " Unsuccessful  ", "Update",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
        //move to new  JFrame if specific button pressed
        if (ae.getSource() == BBMR) {

            try {
                this.toBack();
                BMR b = new BMR();
                b.setVisible(true);
                b.toFront();

            } catch (FileNotFoundException ex) {
                System.out.print("Exception");
            }

        }
        if (ae.getSource() == BSleepSchedule) {

            this.toBack();
            SleepTime b = new SleepTime();
            b.setVisible(true);
            b.toFront();

        }
        if (ae.getSource() == BWaterIntake) {

            this.toBack();
            WaterIntake b = new WaterIntake();
            b.setVisible(true);
            b.toFront();

        }
        if (ae.getSource() == BBMI) {

            try {
                this.toBack();
                BodyMassIndex b = new BodyMassIndex();
                b.setVisible(true);
                b.toFront();

            } catch (IOException ex) {
                System.out.print("Exception");
            }
        }

    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        OOPProject m = new OOPProject();
        m.setVisible(true);

    }
}
