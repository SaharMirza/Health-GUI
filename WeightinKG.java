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
public class WeightinKG extends WeightConvertor{
    public WeightinKG(double p){
        super.setPounds(p);        
        System.out.println("using weight in kg class " + super.getConvert());
    }
}