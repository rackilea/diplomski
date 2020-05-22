public class Planet
{

static int[] moons;

static String[] planets;

Planet(int[] moons, String[] planets) {
    this.moons = moons;
    this.planets = planets;
}

private static String[] planets() {
    String[] planets = { "Mercury moons = ", "Venus moons =  ", "Earth moons = ", "Mars moons = ", "Jupiter moons = ", "Saturn moons = ", "Uranus moons = ", "Neptune moons = ", "Pluto moons = " };
    return planets;
}

private static int[] moons() {
    int[] moons = { 0, 0, 1, 2, 67, 62, 27, 14, 5 };
    return moons;
}

private void pairPlanet() {
    if (moons.length == planets.length) {
        for (int i = 0; i < moons.length; i++) {
            System.out.println(planets[i] + moons[i]);
        }
    }
  }
}