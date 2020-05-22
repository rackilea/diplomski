Map<String, int[]> countries = new HashMap<>();
for(int i = 0; i < COUNTRY.length; i++){
    countries.put(COUNTRY[i], new int[3]);
}
//
for(int j = 0; j < athletes.size(); j++){
    if(j == 3)
        break;
    Athlete a = athletes.get(j);
    int[] medals = countries.get(a.getCountry());
    medals[j]++;
    // last to lines could even be
    // countries.get(a.getCountry())[j]++;
}