package main;

public class RallyChampionship 
{
    public static void main( String[] args )
    {
        //1. Creates and configures the ChampionshipManager singleton
        ChampionshipManager manager = ChampionshipManager.getInstance(); // ensuring only 1 instance gets created

        //2. Create and register driver with appropriate cars
        Driver driver1 = new Driver("Sébastien Ogier", "France", new AsphaltCar("Bugatti","Mistral",1000, 2600));
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland", new GravelCar("Subaru","Impreza WRX STI",300, 0.5));
        Driver driver3 = new Driver("Ott Tänak", "Estonia", new GravelCar("Citroën","C3 WRC",400, 0.75));
        Driver driver4 = new Driver("Thierry Neuville", "Belgium", new AsphaltCar("Porsche","911 GT3 RS",500, 800));
                // PRINT EVERYTHING ACCORDINGLY



        //3. Simulate at least two races with different surfaces
        //4. Display championship standings, statistics, and race results
        //5. Demonstrate car switching between races 
        //6. Show performance calculations for different car types
    }
}
