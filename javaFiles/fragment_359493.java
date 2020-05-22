public void applyBonus(Player player){
    List<City> cities = getCity();
    for(int i = 0; cities != null && i < cities.size(); i++){
        City c = cities.get(i);
        List<Bonus> bonuses = c.getBonus();
        for (int j = 0; bonuses != null && j < bonuses.size(); j++) {
            Bonus b = bonuses.get(j);
            if (b != null)
                b.applyBonus(player);
        }
     }
}