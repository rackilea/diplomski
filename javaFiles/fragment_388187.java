for(Map.Entry<String, Map<String, Double>> entry : usersMap.entrySet()){
    for(Map.Entry<String, Double> ent : entry.getValue().entrySet()){
        Map<String, Double> people = transform.get(ent.getKey());
        if (people == null) {
            people = new HashMap<>();
            transform.put(ent.getKey(), people);
        }
        people.put(entry.getKey(), ent.getValue());
    }
}