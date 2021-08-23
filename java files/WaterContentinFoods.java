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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WaterContentinFoods extends JFrame implements ActionListener {

    //Initializing labels and buttons
    private JLabel Content;
    private JButton  Exit, ReturnToMain;

    //Constructor
    public WaterContentinFoods() {

        //Creating the panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);
        setTitle("WATER CONTENT IN FOODS");
        setBackground(Color.BLACK);

        //Adding the table (image) in form of a label
        String image = "WCIF.JPG";
        Content = new JLabel(new ImageIcon(image));
        Content.setBounds(20, 20, 610, 492);

        

        //Takes you back to the main panel
        ReturnToMain = new JButton("BACK TO MAIN MENU");
        ReturnToMain.setBounds(160, 530, 150, 30);
        ReturnToMain.setBackground(Color.GRAY);
        ReturnToMain.setBorder(null);
        ReturnToMain.addActionListener(this);

        //Closes the window
        Exit = new JButton("EXIT");
        Exit.setBounds(340, 530, 150, 30);
        Exit.setBackground(Color.GRAY);
        Exit.setBorder(null);
        Exit.addActionListener(this);

        //Adding all the labels and buttons to the panel
        add(panel, BorderLayout.CENTER);
        panel.add(Content);
        
        panel.add(Exit);
        panel.add(ReturnToMain);

        //Customizing the frame
        this.setSize(700, 620);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //Action Listener implemented
    public void actionPerformed(ActionEvent ae) {
        

        if (ae.getSource() == Exit) {
            setVisible(false);
        }

        if (ae.getSource() == ReturnToMain) {

            this.toBack();
            setVisible(false);
            new OOPProject().toFront();
        }
    }

}
