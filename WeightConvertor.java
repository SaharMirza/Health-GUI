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
public class WeightConvertor {
     //declaring variables
    public double pounds, finalkg;

    //methid to set the input value in integer
    public void setPounds(int pounds) {
        this.pounds = pounds;
    }
    //setting the input value in double

    public void setPounds(double pounds) {
        this.pounds = pounds;
    }

    public double getPounds() {
        return pounds;
    }

    //converting the value of weight from pounds to kg
    public double getConvert() {
        finalkg = pounds * 0.453592;
        return finalkg;
    }

}


