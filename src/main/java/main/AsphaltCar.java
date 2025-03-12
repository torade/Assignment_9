package main;

public class AsphaltCar extends RallyCar{
    private double downforce;

    public AsphaltCar(String make, String model, int horsepower, double downforce)
    {
        super(make, model, horsepower);
        this.downforce = downforce;
    }

    public double getDownforce()
    {
        return this.downforce;
    }


    // override empty method from abstract parent class: RallyCar.java
    @Override
    public double calculatePerformance()
    {
        return this.getHorsePower()*1.5/this.downforce;
    }
}
