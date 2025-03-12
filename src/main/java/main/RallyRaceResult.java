package main;

import java.util.List;
import java.util.Map;

public class RallyRaceResult implements RaceResult{
    private String raceName, location;
    private Map<Driver, Integer> results;

    public RallyRaceResult(String raceName, String location)
    {
        this.raceName = raceName;
        this.location = location;
    }

    public String getRaceName()
    {
        return this.raceName;
    }

    public String getLocation()
    {
        return this.location;
    }




    //Next methods are inherited from the interface and need to be overriden
    
    @Override
    public void recordResult(Driver driver, int position, int points)
    {
        //...
    }

    @Override
    public int getDriverPoints(Driver driver)
    {
        //...
    }
    
    @Override
    public List<Driver> getResults()
    {
        //...
    }
}
