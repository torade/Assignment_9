package main;

public class Driver {
    private String name, country;
    private int totalPoints; 
    private RallyCar car;

    public Driver (String name, String country, RallyCar car)
    {
        this.name = name;
        this.country = country;
        this.car = car;
        this.totalPoints = 0; // When creating a driver, it initially has 0 points
    }

    public String getName()
    {
        return this.name;
    }

    public String getCountry()
    {
        return this.country;
    }

    public int getPoints()
    {
        return this.totalPoints;
    }

    public RallyCar getCar()
    {
        return this.car;
    }

    public void setCar(RallyCar car)
    {
        this.car = car;
    }

    public void addPoints(int points)
    {
        this.totalPoints = this.totalPoints + points;
    }
}
