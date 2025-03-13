package main;

import java.util.ArrayList;
import java.util.List;

public class RallyChampionship 
{
    public static void main( String[] args )
    {
                    // create a local list of drivers
                    List<Driver> drivers = new ArrayList<>();

        //1. Creates and configures the ChampionshipManager singleton
        ChampionshipManager manager = ChampionshipManager.getInstance(); // ensuring only 1 instance gets created

        //2. Create and register driver with appropriate cars
        GravelCar gravelCar1 = new GravelCar("Subaru","Impreza WRX STI",300, 0.5);
        GravelCar gravelCar2 = new GravelCar("Citroën","C3 WRC",400, 0.75);
        AsphaltCar asphaltCar1 = new AsphaltCar("Bugatti","Mistral",1000, 2600);
        AsphaltCar asphaltCar2 = new AsphaltCar("Porsche","911 GT3 RS",500, 800);

        Driver driver1 = new Driver("Sébastien Ogier", "France", asphaltCar1);
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland", asphaltCar1);
        Driver driver3 = new Driver("Ott Tänak", "Estonia", asphaltCar2);
        Driver driver4 = new Driver("Thierry Neuville", "Belgium", asphaltCar2);
        drivers.add(driver1); drivers.add(driver2); drivers.add(driver3); drivers.add(driver4);

                //register drivers into ChampionshipManager
                for (Driver driver : drivers)
                    manager.registerDriver(driver);

        //3. Simulate at least two races with different surfaces
                //1st race (asphalt):
                RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyväskylä");
                race1.recordResult(driver1, 1, 20);
                race1.recordResult(driver2, 2, 15);
                race1.recordResult(driver3, 3, 10);
                race1.recordResult(driver4, 4, 5);
                        //store points for each driver in Driver.java
                        for (Driver driver : drivers)
                            driver.addPoints(race1.getDriverPoints(driver));
                
                //2nd race (gravel):
                        //(5. Demonstrate car switching between races)
                        driver1.setCar(gravelCar1);
                        driver2.setCar(gravelCar1);
                        driver3.setCar(gravelCar2);
                        driver4.setCar(gravelCar2);
                RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");
                race2.recordResult(driver3, 1, 20);
                race2.recordResult(driver2, 2, 15);
                race2.recordResult(driver4, 3, 10);
                race2.recordResult(driver1, 4, 5);
                        //store points for each driver in Driver.java
                        for (Driver driver : drivers)
                            driver.addPoints(race2.getDriverPoints(driver));

                //add the results into ChampionshipManager
                manager.addRaceResult(race1);
                manager.addRaceResult(race2);

        //4. Display championship standings, statistics, and race results
                //standings:
                 drivers = manager.getDriverStandings();
                int i = 0;
                for (Driver driver : drivers)
                {
                    i++;
                    System.out.println(i + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getPoints() + " points");
                }

                //championship leader
                System.out.println("\n\n===== CHAMPIONSHIP LEADER =====");
                Driver leadingDriver = ChampionshipManager.getLeadingDriver();
                System.out.println(leadingDriver.getName() + " with " + leadingDriver.getPoints() + " points");

                //championship statistics
                System.out.println("\n\n===== CHAMPIONSHIP STATISTICS =====");
                System.out.println("Total Drivers: " + ChampionshipManager.getTotalDrivers());
                System.out.println("Total Races: " + ChampionshipManager.getTotalRaces());
                System.out.println("Average Points Per Driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(drivers));
                System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(drivers));
                System.out.println("Total Championship Points: " + ChampionshipManager.getTotalChampionshipPoints());


        System.out.println("\n\n===== RACE RESULTS =====");
        List<RallyRaceResult> races = new ArrayList<>();
        races.add(race1);
        races.add(race2);
        for (RallyRaceResult race : races)
        {
            System.out.println("Race " + race.getRaceName() + "(" + race.getLocation() + ")");
                drivers = race.getResults();
                i = 0;
                for (Driver driver : drivers)
                {
                    i++;
                    System.out.println("Position " + i + ": " + driver.getName() + " - " + race.getDriverPoints(driver) + " points");
                }
            System.out.println("\n");
        }
        //6. Show performance calculations for different car types
        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        List<RallyCar> cars = new ArrayList<>();
        cars.add(asphaltCar1); cars.add(asphaltCar2); cars.add(gravelCar1); cars.add(gravelCar2); // <-adding cars to a list to process them quicker
        for (RallyCar car : cars)
        {
            if (car instanceof GravelCar)
                System.out.print("Gravel Car ");
            else
                System.out.print("Asphalt Car ");
            System.out.println(car.getMake() + " " + car.getModel() + " Performance: " + car.calculatePerformance());
        }
        
    }
}
