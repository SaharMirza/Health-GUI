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

public class Category extends JFrame implements ActionListener {

    //declaring variables
    private JButton BackB, ExitB, categoryB;
    private JLabel categoryL, riskL, image, graph;
    private double bmi;

    public Category(double bmi) throws FileNotFoundException {
        this.bmi = bmi;
        //creating a new JPanel, setting title and color
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        add(panel);
        panel.setLayout(null);
        setTitle("BMI Classes/Categories");
        setBackground(Color.BLACK);

        //conditions for category
        if (bmi < 15) {
            categoryL = new JLabel("You Are Very Severely Under Weight!", SwingConstants.CENTER);
            riskL = new JLabel("Mortality Risk Is Moderate", SwingConstants.CENTER);
            riskL.setForeground(new Color(255, 255, 153));
        } else if (bmi >= 15 && bmi < 16) {
            categoryL = new JLabel("You Are Severely Under Weight!", SwingConstants.CENTER);
            riskL = new JLabel("Mortality Risk Is Moderate", SwingConstants.CENTER);
            riskL.setForeground(new Color(255, 255, 153));
        } else if (bmi >= 16 && bmi < 18.5) {
            categoryL = new JLabel("You Are Under Weight!", SwingConstants.CENTER);
            riskL = new JLabel("Mortality Risk Is Moderate", SwingConstants.CENTER);
            riskL.setForeground(new Color(255, 255, 153));
        } else if (bmi >= 18.5 && bmi < 25) {
            categoryL = new JLabel("You Are Normal(Healthy)!", SwingConstants.CENTER);
            riskL = new JLabel("Mortality Risk Is Very Low", SwingConstants.CENTER);
            riskL.setForeground(new Color(153, 255, 153));
        } else if (bmi >= 25 && bmi < 30) {
            categoryL = new JLabel("You Are Over Weight!", SwingConstants.CENTER);
            riskL = new JLabel("Mortality Risk Is Low", SwingConstants.CENTER);
            riskL.setForeground(new Color(153, 255, 153));
        } else if (bmi >= 30 && bmi < 35) {
            categoryL = new JLabel("You Are Moderately Obese!", SwingConstants.CENTER);
            riskL = new JLabel("Mortality Risk Is Moderate", SwingConstants.CENTER);
            riskL.setForeground(new Color(255, 255, 153));
        } else if (bmi >= 35 && bmi < 40) {
            categoryL = new JLabel("You Are Severely Obese!", SwingConstants.CENTER);
            riskL = new JLabel("Mortality Risk Is High", SwingConstants.CENTER);
            riskL.setForeground(new Color(204, 0, 0));
        } else if (bmi >= 40) {
            categoryL = new JLabel("You Are Very Severely Obese!", SwingConstants.CENTER);
            riskL = new JLabel("Mortality Risk Is Very High", SwingConstants.CENTER);
            riskL.setForeground(new Color(204, 0, 0));
        }

        //setting up label for category
        categoryL.setBounds(0, 54, 600, 50);
        categoryL.setForeground(Color.GRAY);
        categoryL.setBackground(new Color(72, 61, 112));
        categoryL.setOpaque(true);
        categoryL.setFont(new Font("Calibri", Font.BOLD, 24));
        categoryL.setVisible(false);

        //settinguplabel for mortality risk
        riskL.setBounds(0, 104, 600, 50);
        riskL.setBackground(Color.DARK_GRAY);
        riskL.setOpaque(true);
        riskL.setFont(new Font("Calibri", Font.BOLD, 24));
        riskL.setVisible(false);

        //setting label to put up an image
        image = new JLabel(new ImageIcon("bmimeter.PNG"));
        image.setBounds(20, 27, 80, 51);

        //setting label to insert graph
        graph = new JLabel(new ImageIcon("bmigraph.PNG"));
        graph.setBounds(10, 164, 578, 350);

        //creating button to go back to  personal info page
        BackB = new JButton("BACK");
        BackB.setBounds(100, 520, 150, 30);
        BackB.setBackground(Color.GRAY);
        BackB.addActionListener(this);

        //creating button to close frame
        ExitB = new JButton("EXIT");
        ExitB.setBounds(320, 520, 150, 30);
        ExitB.setBackground(Color.GRAY);
        ExitB.addActionListener(this);

        //creating button to show user's category and risk level when clicked
        categoryB = new JButton("Category And Risk Level");
        categoryB.setForeground(Color.WHITE);
        categoryB.setBounds(210, 23, 175, 30);
        categoryB.setBackground(Color.GRAY);
        categoryB.addActionListener(this);

        //adding buttons and labels to panel
        panel.add(BackB);
        panel.add(ExitB);
        panel.add(image);
        panel.add(categoryB);
        panel.add(categoryL);
        panel.add(riskL);
        panel.add(graph);

        //setting size and layout of panel
        add(panel, BorderLayout.CENTER);
        this.setSize(620, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        //using if conditions to give functionality to the buttons
        if (ae.getSource() == ExitB) {
            System.exit(0);
        }
        if (ae.getSource() == BackB) {

            try {

                this.setVisible(false);
                new BodyMassIndex().toFront();
            } catch (IOException ex) {
                Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ae.getSource() == categoryB) {
            categoryL.setVisible(true);
            riskL.setVisible(true);
        }

    }

}
