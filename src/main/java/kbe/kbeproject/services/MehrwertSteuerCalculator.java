package kbe.kbeproject.services;/*
 * @author Hitzek, Steffen; Matr.Nr 566507
 * @author Schöbel, Susann; Matr.Nr 571657
 */

import kbe.kbeproject.products.Product;

public class MehrwertSteuerCalculator {

    private static final Double MEHRWERTSTEUER = 0.19;

    public Product getMehrwertSteuer(Product p) {
        Product resultProduct =  p;
        p.setPrice(p.getPrice() + p.getPrice() * MEHRWERTSTEUER);
        return resultProduct;
    }
}
