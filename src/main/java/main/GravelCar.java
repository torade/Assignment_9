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
        double performance =  this.getHorsePower()/this.suspensionTravel;
        return Math.round(performance*100.0)/100.0;
    }
}
