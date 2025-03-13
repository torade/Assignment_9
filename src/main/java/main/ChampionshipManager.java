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
        totalDrivers = 0;
        totalRaces = 0;
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
        totalDrivers++;
    }

    public void addRaceResult(RallyRaceResult result)
    {
        this.races.add(result);
        totalRaces++;
    }

    public List<Driver> getDriverStandings() //idk if this should be static or not.
    {
        List<Driver> sortedDrivers = new ArrayList<>(this.drivers);
        sortedDrivers.sort((d1, d2) -> Integer.compare(d2.getPoints(), d1.getPoints())); //sorting them in descending order based on points
        return sortedDrivers;
    }

    public static Driver getLeadingDriver()
    {
        ChampionshipManager championshipManager = ChampionshipManager.getInstance();
        return championshipManager.getDriverStandings().get(0);
    }

    public static int getTotalChampionshipPoints()
    {
        int totalPoints = 0;
        ChampionshipManager championshipManager = ChampionshipManager.getInstance();
        for (Driver driver : championshipManager.drivers)
        {
            totalPoints = totalPoints + driver.getPoints();
        }
        return totalPoints;

    }
    
    //other needed getters
    public static int getTotalDrivers()
    {
        return totalDrivers;
    }
    public static int getTotalRaces()
    {
        return totalRaces;
    }


}
