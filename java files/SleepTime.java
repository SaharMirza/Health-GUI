/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class SleepTime extends JFrame implements ActionListener {

    private JButton Wakeup, Bedtime, Exit, Back, UpdateB;
    private JLabel Duration, Time, Result, h, min, dh, dmin;
    private JTextField TimeF, DurationF, durationh, durationm;
    private JComboBox ClockHour, ClockMinute;

    public SleepTime() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);
        add(panel, BorderLayout.CENTER);
        setTitle("Sleep Time");
        setBackground(Color.BLACK);

        ////////////Buttons\\\\\\\\
        Wakeup = new JButton("WAKE UP TIME");
        Bedtime = new JButton("BEDTIME");
        Exit = new JButton("EXIT");
        Back = new JButton("BACK");
        UpdateB = new JButton("CALCULATE TIME");

        Wakeup.setBounds(55, 30, 120, 25);
        Bedtime.setBounds(205, 30, 120, 25);
        Exit.setBounds(205, 390, 120, 25);
        Back.setBounds(55, 390, 120, 25);
        UpdateB.setBounds(40, 235, 140, 25);

        Wakeup.setForeground(Color.WHITE);
        Bedtime.setForeground(Color.WHITE);
        Exit.setForeground(Color.BLACK);
        Back.setForeground(Color.BLACK);
        UpdateB.setForeground(Color.WHITE);

        Wakeup.setBackground(Color.GRAY);
        Bedtime.setBackground(Color.GRAY);
        Exit.setBackground(Color.GRAY);
        Back.setBackground(Color.GRAY);
        UpdateB.setBackground(Color.GRAY);

        Wakeup.addActionListener(this);
        Bedtime.addActionListener(this);
        Exit.addActionListener(this);
        Back.addActionListener(this);
        UpdateB.addActionListener(this);

        panel.add(Wakeup);
        panel.add(Bedtime);
        panel.add(Exit);
        panel.add(Back);
        panel.add(UpdateB);

        ///////////Labels\\\\\\\\\\\\\\
        Font f = new Font("Calbiri (Body)", Font.PLAIN, 18);
        Font a = new Font("Calbiri (Body)", Font.PLAIN, 30);

        Time = new JLabel("Sleep Time");
        Duration = new JLabel("Duration Of Sleep");
        Result = new JLabel("Wake Up Time", SwingConstants.CENTER);
        h = new JLabel("Hours");
        min = new JLabel("Minutes");
        dh = new JLabel("Hours");
        dmin = new JLabel("Minutes");

        Result.setBounds(40, 290, 300, 80);
        Time.setBounds(40, 70, 300, 25);
        Duration.setBounds(40, 155, 200, 25);
        h.setBounds(125, 110, 300, 25);
        min.setBounds(275, 110, 300, 25);
        dh.setBounds(125, 190, 200, 25);
        dmin.setBounds(275, 190, 200, 25);

        Result.setForeground(Color.WHITE);
        Time.setForeground(Color.WHITE);
        Duration.setForeground(Color.WHITE);
        h.setForeground(Color.WHITE);
        dh.setForeground(Color.WHITE);
        min.setForeground(Color.WHITE);
        dmin.setForeground(Color.WHITE);

        Result.setBackground(new Color(72, 61, 112));
        Result.setOpaque(true);

        Time.setFont(f);
        Duration.setFont(f);
        Result.setFont(a);

        panel.add(Time);
        panel.add(Duration);
        panel.add(Result);
        panel.add(h);
        panel.add(min);
        panel.add(dh);
        panel.add(dmin);
        //////////TextField\\\\\\\\\\\\\\
        durationh = new JTextField();
        durationm = new JTextField();

        durationh.setHorizontalAlignment(JTextField.CENTER);
        durationm.setHorizontalAlignment(JTextField.CENTER);
        durationh.setCaretColor(Color.WHITE);
        durationm.setCaretColor(Color.WHITE);

        durationh.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.GRAY));
        durationm.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.GRAY));

        durationh.setBackground(Color.DARK_GRAY);
        durationm.setBackground(Color.DARK_GRAY);

        durationh.setForeground(Color.WHITE);
        durationm.setForeground(Color.WHITE);

        durationh.setBounds(40, 180, 80, 30);
        durationm.setBounds(190, 180, 80, 30);

        durationh.setFont(f);
        durationm.setFont(f);
        durationh.addActionListener(this);
        durationm.addActionListener(this);

        ////////////JComboBox\\\\\\\\\\\\\\
        /////////ComboBox for Hours\\\\\\\
        int len = 24;
        String hours[] = new String[len];
        for (int i = 0; i < len; i++) {
            if (i < 10) {
                hours[i] = "0" + i;
            } else {
                hours[i] = "" + i;
            }
        }

        ClockHour = new JComboBox(hours);
        ClockHour.setBackground(Color.GRAY);
        ClockHour.setForeground(Color.WHITE);

        ClockHour.setLocation(40, 110);
        ClockHour.setSize(80, 25);
        ClockHour.setVisible(true);
        panel.add(ClockHour);
        ClockHour.addActionListener(this);

        ///////ComboBox for Minutes\\\\\\\\\\\
        String minutes[] = new String[60];
        for (int i = 0; i < 60; i++) {
            if (i < 10) {
                minutes[i] = "0" + i;
            } else {
                minutes[i] = "" + i;
            }

        }
        ClockMinute = new JComboBox(minutes);
        ClockMinute.setBackground(Color.GRAY);
        ClockMinute.setForeground(Color.WHITE);
        ClockMinute.setLocation(190, 110);
        ClockMinute.setSize(80, 25);
        ClockMinute.setVisible(true);
        panel.add(ClockMinute);
        ClockMinute.addActionListener(this);

        panel.add(durationh);
        panel.add(durationm);

        this.setSize(400, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Wakeup) {
            Time.setText("Sleep Time");
        }
        if (ae.getSource() == Bedtime) {
            Time.setText("Wake Up Time");
            Result.setText("Sleep Time");

        }
        if (ae.getSource() == UpdateB) {

            //calculation
            int hr = Integer.parseInt((String) ClockHour.getSelectedItem());
            int min = Integer.parseInt((String) ClockMinute.getSelectedItem());
            int durationhr = Integer.parseInt(durationh.getText());
            int durationmin = Integer.parseInt(durationm.getText());
            if (Time.getText().equals("Sleep Time")) {

                int finalhr = hr + durationhr;
                int finalmin = min + durationmin;
                if (finalmin > 59) {
                    finalhr += 1;
                    finalmin -= 60;
                }
                if (finalhr > 23) {
                    finalhr = finalhr - 24;

                }
                if (finalhr < 10 && finalmin > 9) {
                    Result.setText("Wake Up Time " + "0" + finalhr + ":" + finalmin);
                } else if (finalmin < 10 && finalhr > 9) {
                    Result.setText("Wake Up Time " + finalhr + ":0" + finalmin);
                } else if (finalhr < 10 && finalmin < 10) {
                    Result.setText("Wake Up Time " + "0" + finalhr + ":0" + finalmin);
                } else {
                    Result.setText("Wake Up Time " + finalhr + ":" + finalmin);
                }

            }
            if (Time.getText().equals("Wake Up Time")) {
                int finalhr = hr - durationhr;
                int finalmin = min - durationmin;
                if (finalmin < 0) {
                    finalmin = finalmin + 60;
                    finalhr = finalhr - 1;
                }
                if (finalhr < 0) {
                    finalhr = 24 + finalhr;
                }
                if (finalhr < 10 && finalmin > 9) {
                    Result.setText("Sleep Time " + "0" + finalhr + ":" + finalmin);
                } else if (finalmin < 10 && finalhr > 9) {
                    Result.setText("Sleep  Time " + finalhr + ":0" + finalmin);
                } else if (finalhr < 10 && finalmin < 10) {
                    Result.setText("Sleep Time " + "0" + finalhr + ":0" + finalmin);
                } else {
                    Result.setText("Sleep Time " + finalhr + ":" + finalmin);
                }

            }
        }

        if (ae.getSource() == Back) {
            this.toBack();
            this.setVisible(false);
            new OOPProject().toFront();

        }
        if (ae.getSource() == Exit) {
            this.setVisible(false);

        }

    }

}
