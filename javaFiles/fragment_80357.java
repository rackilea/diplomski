public Country highestGdp(String continent) {
    boolean flag;
    Country maxCountry = null;
    for (Country cont : ElementsList) {
        if (cont.getContinent().equals(continent)) {
            if (maxCountry == null) maxCountry = cont;
            if (maxCountry.getGDP() < gdp.getGDP()) {
                maxCountry = cont;
            }
        }
    }
    return maxCountry;
}