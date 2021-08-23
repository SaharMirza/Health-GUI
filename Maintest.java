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
public class Maintest {
     public static void main(String[] args) {
        WeightConvertor wc = new WeightConvertor();
        wc.setPounds(4.0);
        wc.getPounds();
        System.out.println("Weight in Kg is " + wc.getConvert());

        WeightinKG KG = new WeightinKG(1);


        HeightFI hfi = new HeightCM(5,4);
        System.out.println("The height converted in cm is: " + hfi.convert());
    }
}
