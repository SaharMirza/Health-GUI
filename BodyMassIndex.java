/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BodyMassIndex extends JFrame implements ActionListener {

    //declaring variables
    private double height, weight, convertedheight, BMIvalue;
    private JLabel label1, label2, label3, label4, label5;
    private String name;
    private JButton BMICalc, BackB, CategoryB, ExitB;

    public BodyMassIndex() throws FileNotFoundException, IOException {
        //creating a new JPanel, setting color and title
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        add(panel);
        panel.setLayout(null);
        setTitle("Body Mass Index Calculator");
        setBackground(Color.BLACK);

        //creating a new file
        File file = new File("datafile.txt");
        Scanner scan = new Scanner(file);

        //reading name from file
        String Name = scan.nextLine();
        name = Name.substring(6);

        //reading weight from file
        scan.nextLine();
        scan.nextLine();
        String WeightFile = "";
        WeightFile = WeightFile.concat(scan.nextLine());
        String Weight = WeightFile.substring(15);
        weight = Double.parseDouble(Weight);

        //reading height
        String HeightFile = "";
        HeightFile = HeightFile.concat(scan.nextLine());
        String Height = HeightFile.substring(15);
        height = Double.parseDouble(Height);

        //converting height into m
        convertedheight = height / 100;

        //finding out the BMI value  
        BMIvalue = Math.rint((weight / (convertedheight * convertedheight)) * 10) / 10;

        //making another file to save the value of BMI
        File file2 = new File("BMIvalue.txt");
        FileWriter writer = new FileWriter(file2);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("BMIvalue: " + BMIvalue + " kg/m\u00B2");
        bw.close();

        //creating label for welcoming user
        label1 = new JLabel("Hey " + name + "!");
        label1.setFont(new Font("Calibri (body)", Font.ITALIC, 22));
        label1.setForeground(Color.WHITE);
        label1.setBounds(27, 1, 500, 75);

        //creating label for heading
        label2 = new JLabel("What is BMI?", SwingConstants.CENTER);
        label2.setFont(new Font("Calibri(body)", Font.BOLD, 22));
        label2.setForeground(Color.WHITE);
        label2.setBounds(27, 40, 300, 75);

        //text for general info
        String text = "Body mass index, or BMI, is a measure of body size. "
                + "It combines a person’s weight with their height. The results"
                + " of a BMI measurement can give an idea about whether you have"
                + " the correct weight for your height.";

        //creating label for general info
        label3 = new JLabel("<html>" + text + "<html");
        label3.setBounds(27, 110, 350, 150);
        label3.setFont(new Font("Calibri(body)", Font.PLAIN, 18));
        label3.setForeground(Color.WHITE);

        //creating label for showing user's BMI value
        label4 = new JLabel("       Your BMI is: " + BMIvalue + " kg/m\u00B2");
        label4.setBounds(0, 310, 400, 75);
        label4.setForeground(Color.GRAY);
        label4.setBackground(new Color(72, 61, 112));
        label4.setOpaque(true);
        label4.setFont(new Font("Calibri", Font.BOLD, 30));
        label4.setVisible(false);

        //creating label to insert image
        label5 = new JLabel(new ImageIcon("bmisymbol.PNG"));
        label5.setBounds(270, 30, 75, 75);

        //creating button to calculate BMI
        BMICalc = new JButton("CALCULATE BMI");
        BMICalc.setBounds(57, 275, 150, 20);
        BMICalc.setForeground(Color.WHITE);
        BMICalc.setBackground(Color.GRAY);
        BMICalc.addActionListener(this);

        //creating button to go back
        BackB = new JButton("BACK");
        BackB.setBounds(47, 410, 70, 30);
        BackB.setBackground(Color.GRAY);
        BackB.addActionListener(this);

        //creatingbutton to go to the next panel to find out category
        CategoryB = new JButton("CATEGORIES");
        CategoryB.setBounds(130, 410, 120, 30);
        CategoryB.setBackground(Color.GRAY);
        CategoryB.addActionListener(this);

        //creating exit button to close frame
        ExitB = new JButton("EXIT");
        ExitB.setBounds(260, 410, 70, 30);
        ExitB.setBackground(Color.GRAY);
        ExitB.addActionListener(this);

        //adding all labels and buttons to thepanel
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(BMICalc);
        panel.add(BackB);
        panel.add(CategoryB);
        panel.add(ExitB);

        //setting size and layout
        add(panel, BorderLayout.CENTER);
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        //using if conditions to give functionality to the buttons
        if (ae.getSource() == BMICalc) {
            label4.setVisible(true);
        }
        if (ae.getSource() == CategoryB) {

            this.setVisible(false);
            try {
                Category content = new Category(BMIvalue);
            } catch (FileNotFoundException ex) {
                System.out.println("Excepion");
            }

        }
        if (ae.getSource() == ExitB) {
            System.exit(0);
        }

        if (ae.getSource() == BackB) {
            this.toBack();
            this.setVisible(false);

            new OOPProject().toFront();

        }

    }
}
