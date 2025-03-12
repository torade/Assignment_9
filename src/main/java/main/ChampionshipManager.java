package main;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    private List<RallyRaceResult> races;
    private static int totalDrivers, totalRaces;

    //private constructor to limit the creation of multiple instances (we want a singleton)
    private ChampionshipManager()
    {
        this.drivers = new ArrayList<>();
        this.races = new ArrayList<>();
    }

    /*
     * Setting constraints of only creating 1 instance of ChampionshipManager
     */
    public static ChampionshipManager getInstance()
    {
        if (instance == null)
            instance = new ChampionshipManager();
        return instance;
    }

    public void registerDriver(Driver driver)
    {
        this.drivers.add(driver);
    }

    public void addRaceResult(RallyRaceResult result)
    {
        this.races.add(result);
    }

    public List<Driver> getDriverStandings() //idk if this should be static or not. If it is static, I must change List<Driver> drivers to static too
    {
        //...
    }

    public static Driver getLeadingDriver()
    {
        //...
    }

    public static int getTotalChampionshipPoints()
    {
        //...
    }



}
