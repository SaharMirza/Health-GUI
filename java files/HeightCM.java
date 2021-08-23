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
public class HeightCM implements HeightFI{
    //declaring variable
    private int feet, inches;

    public HeightCM(int feet, int inches) {
        //initialising variables
        this.feet = feet;
        this.inches = inches;
    }
    
    //method to convert height incm to feet and  inches
    public double convert() {
        double cm = (30.48 * feet) + 2.54 * inches;
        return cm;
    }

}

