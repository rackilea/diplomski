public int populationForCountry(String country) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i].equals(country)) {
                return populations[i];
            }
        }
        return -1;
    }