package main;

import java.util.List;

public class ChampionshipStatistics {

    public static double calculateAveragePointsPerDriver(List<Driver> drivers)
    {
        double points = 0, i = 0;
        for (Driver driver : drivers)
        {
            i++;
            points = points + driver.getPoints();
        }
        return points/i; //average
        
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) //only works if i have 1 driver from 1 country !!!!
    {
        int maxPoints = -1;
        String country = "";
        for (Driver driver : drivers)
        {
            if (driver.getPoints() > maxPoints)
            {
                maxPoints = driver.getPoints();
                country = driver.getCountry();
            }
        }
        return country; //country of the driver with the largest amount of points
    }

    public static int getTotalRacesHeld()
    {
        return ChampionshipManager.getTotalRaces();
    }
}
