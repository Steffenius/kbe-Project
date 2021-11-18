package kbe.kbeproject.services;/*
 * @author Hitzek, Steffen; Matr.Nr 566507
 * @author Schöbel, Susann; Matr.Nr 571657
 */

import kbe.kbeproject.products.Product;

public class MehrwertsteuerCalculator {

    private final Double mehrwertSteuerPercentage = 0.19;

    public Double calculateMehrwertSteuer(Product p){
        try {
            return (p.getPrice() * mehrwertSteuerPercentage);
        } catch (Exception e) {
            System.out.print("Something with Product isn't valid for tax calculation" + e.getMessage());
        }
        return 0.0;
    }
}
