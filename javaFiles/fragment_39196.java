public static void main(String[] args) throws IOException {
    String populationString = "";
    String[] line = new String[201];
    int populations[] = new int[201];

    // Have a dictionary that can store the values you parse
    Map<Integer, String> dictionary = new HashMap<Integer, String>();

    Scanner fileIN = new Scanner(new File("F:/CountrySortedAlpha.txt"));

    while (fileIN.hasNext()) {
        for (int i = 0; i < 201; i++) {
            // Parse the whole line, this 29 hard coded seems incorrect
            populationString = fileIN.nextLine().substring(0, 29);
            // Grab both values
            String[] splited = populationString.split("\\s+");
            // Country name can have spaces, so take the last elemnt
            populations[i] = Integer.parseInt(splited[splited.length - 1]);
            // Join back values
            String country = populationString.join(" ", splited);
            // Cut off the rate number
            country = country.substring(0, country.lastIndexOf(" "));
            // Store them in your dictionary
            if (dictionary.containsKey(populations[i])) {
                // If multiple countries have same rate, add them to value, and separate with comma
                String value = dictionary.get(populations[i]);
                dictionary.put(populations[i], value + "," + country);
            } else {
                dictionary.put(populations[i], country);
            }
        }
        int j;
        for (int gap = populations.length / 2; gap > 0; gap /= 2) {
            for (int t = gap; t < populations.length; t++) {
                int tmp = populations[t];
                for (j = t; j >= gap && (tmp < populations[j - gap]); j -= gap) {
                    populations[j] = populations[j - gap];
                }
                populations[j] = tmp;
            }
        }
        System.out.println("Final sorted order: ");
        for (int k = 0; k < populations.length; k++) {
            // Read the value from dictionary
            String value = dictionary.get(populations[k]);
            // For duplicates skip, that entry gets deleted after values were printed
            if (value == null) {
                continue;
            }

            // If multiple countries had the same rate, they were stored as comma separated value
            String[] countries = value.split(",");
            for (String country : countries) {
                // You can print rate, or country, or both
                System.out.println(populations[k] + " " + country);
            }

            // Remove from dictionary, because we already printed all countries with the same rate
            dictionary.remove(populations[k]);
        }
        System.out.println();
    }

    // Don't forget to close the file
    fileIN.close();
}