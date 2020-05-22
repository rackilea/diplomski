HashMap<String, ArrayList<Integer>> countries = new HashMap<>();
ArrayList<Integer> medals = new ArrayList<>();
medals.add(0); medals.add(0); medals.add(0);
for(int i = 0; i < COUNTRY.length; i++){
    countries.put(COUNTRY[i], medals);
}