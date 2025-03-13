package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RallyRaceResult implements RaceResult{
    private String raceName, location;
    private Map<Driver, Integer> results;

    public RallyRaceResult(String raceName, String location)
    {
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>();
    }

    public String getRaceName()
    {
        return this.raceName;
    }

    public String getLocation()
    {
        return this.location;
    }




    //Next methods are inherited from the interface and are meant to be overriden
    
    @Override
    public void recordResult(Driver driver, int position, int points) //the Map only has Driver and integer, so i can't store both position and points in the result?
    {
        this.results.put(driver, points);
    }

    @Override
    public int getDriverPoints(Driver driver)
    {
        return this.results.get(driver); //returns points of the driver
    }   
    
    @Override
    public List<Driver> getResults() //this method is similar to getDriverStandings() inside ChampionshipManager.java
    {
        List<Driver> sortedDrivers = new ArrayList<>(); 
        for (Driver driver : results.keySet()) //add the drivers from the Map into a List
            sortedDrivers.add(driver);
        
        sortedDrivers.sort((d1, d2) -> Integer.compare(results.get(d2), results.get(d1))); //sorting them in descending order based on points (in the current race)
        return sortedDrivers;
    }


}
