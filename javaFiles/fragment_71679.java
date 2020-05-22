public class Galaxy
{
    String galaxyName;
    int galaxySolarSystems;
    int galaxyPlanets;
    long galaxyColonies;
    double galaxyLifeforms;
    int galaxyFleets;
    int galaxyStarships;

    public Galaxy(String name, int solarSys, int planets)
    {
        galaxyName = name;
        galaxySolarSystems = solarSys;
        galaxyPlanets = planets;
        galaxyColonies = 0;
        galaxyLifeforms = 0;
        galaxyFleets = 0;
        galaxyStarships = 0;
    }
}