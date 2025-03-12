package main;

public abstract class RallyCar {
    private String make, model;
    private int horsepower;

    public RallyCar (String make, String model, int horsepower)
    {
        this.make = make;
        this.model = model;
        this. horsepower = horsepower;
    }

    public String getMake()
    {
        return this.make;
    }

    public String getModel()
    {
        return this.model;
    }

    public int getHorsePower()
    {
        return this.horsepower;
    }

    public abstract double calculatePerformance();
}
