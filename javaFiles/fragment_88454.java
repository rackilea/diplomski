import org.apache.commons.lang3.ArrayUtils;

public class PopulationLookup {
    private String[] countries;
    private int[] populations;

    public PopulationLookup(String[] countries, int[] populations) {
        this.countries = countries;
        this.populations = populations;
    }

    public void printAll() {
        for (int i = 0; i < countries.length; i++) {
            System.out.format(
                "Country: %s, population %d%n", countries[i], populations[i]);
        }
    }

    public int populationForCountry(String country) {
        int entry = ArrayUtils.indexOf(countries, country);
        if (entry != -1) {
            return populations[entry];
        } else {
            return -1;
        }
    }
}