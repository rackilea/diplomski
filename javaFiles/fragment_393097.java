while(keySetIterator.hasNext()){
        String key = keySetIterator.next();
        System.out.println("key: " + key + " value: " + cities.get(key).getName());
        if (cities.get(key).getName().contains(searchtext)) {
                  System.out.println("Value result found " + cities.get(key).getCountry() + " " + cities.get(key).getPopulation());
        }
}