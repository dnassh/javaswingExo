package org.exercice.model;

public class Spectacle {
    private int number;
    private String description;
    private int nbrBillets;
    private int billetsDispos;
    private double price;

    public Spectacle(){

    }
    public Spectacle(int number, String description, int nbrBillets, int billetsDispos, double price) {
        this.number = number;
        this.description = description;
        this.nbrBillets = nbrBillets;
        this.billetsDispos = billetsDispos;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbrBillets() {
        return nbrBillets;
    }

    public void setNbrBillets(int nbrBillets) {
        this.nbrBillets = nbrBillets;
    }

    public int getBilletsDispos() {
        return billetsDispos;
    }

    public void setBilletsDispos(int billetsDispos) {
        this.billetsDispos = billetsDispos;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Spectacle{" +
                "number=" + number +
                ", description='" + description + '\'' +
                ", nbrBillets=" + nbrBillets +
                ", billetsDispos=" + billetsDispos +
                ", price=" + price +
                '}';
    }
}
