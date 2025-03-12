package main;

public class GravelCar extends RallyCar{
    private double suspensionTravel;

    public GravelCar(String make, String model, int horsepower, double suspensionTravel)
    {
        super(make,model, horsepower);
        this.suspensionTravel = suspensionTravel;
    }

    public double getSuspensionTravel()
    {
        return this.suspensionTravel;
    }


    // override empty method from abstract parent class: RallyCar.java
    @Override
    public double calculatePerformance()
    {
        return this.getHorsePower()*2/this.suspensionTravel;
    }
}
