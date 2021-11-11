package kbe.kbeproject.products;/*
 * @author Hitzek, Steffen; Matr.Nr 566507
 * @author Schöbel, Susann; Matr.Nr 571657
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
class Product {

    private @Id @GeneratedValue UUID id = UUID.randomUUID();
    private String name;
    private int price;
    private String color;
    private Double displaySize;
    private String chip;
    private String memory;
    private int deliveryTime;
    private String location;
    private String description;
    private String camera;

    // throws some error
    // Employee() {}
    public Product(){}


    Product(String name, int price, String color,Double displaySize, String chip,
            String memory,int deliveryTime, String location, String description, String camera) {

        this.name = name;
        this.price  = price;
        this.color = color;
        this.displaySize = displaySize;
        this.chip = chip;
        this.memory = memory;
        this. deliveryTime = deliveryTime;
        this.location = location;
        this.description = description;
        this.camera = camera;
    }


    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public Double getDisplaySize() {
        return displaySize;
    }

    public String getChip() {
        return chip;
    }

    public String getMemory() {
        return memory;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getCamera() {
        return camera;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDisplaySize(Double displaySize) {
        this.displaySize = displaySize;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return Objects.equals(this.id, product.id) &&
                   Objects.equals(this.name, product.name) &&
                   Objects.equals(this.price, product.price) &&
                   Objects.equals(this.color, product.color) &&
                   Objects.equals(this.displaySize, product.displaySize) &&
                   Objects.equals(this.chip, product.chip) &&
                   Objects.equals(this.memory, product.memory) &&
                   Objects.equals(this.deliveryTime, product.deliveryTime) &&
                   Objects.equals(this.location, product.location) &&
                   Objects.equals(this.description, product.description) &&
                   Objects.equals(this.camera, product.camera);

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", displaySize=" + displaySize +
                ", chip='" + chip + '\'' +
                ", memory='" + memory + '\'' +
                ", deliveryTime=" + deliveryTime +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", camera='" + camera + '\'' +
                '}';
    }
}