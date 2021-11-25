package com.example.testfirestore;

public class Courses {

    // variables for storing our data.
    private String Name, Price, Taste;

    public Courses() {
        // empty constructor
        // required for Firebase.
    }

    // Constructor for all variables.
    public Courses(String Name, String Price, String Taste) {
        this.Name = Name;
        this.Price = Price;
        this.Taste = Taste;
    }

    // getter methods for all variables.
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPrice() {
        return Price;
    }

    // setter method for all variables.
    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getTaste() {
        return Taste;
    }

    public void setTaste(String Taste) {
        this.Taste = Taste;
    }
}

