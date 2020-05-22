Map<MonthCountryKey,List<Human>> buckets = new HashMap<List<Human>>;

while(Human human = humanSource.get()) {
    MonthCountryKey key = new MonthCountryKey(human.getMonthOfBirth(), human.getCountry());
    List list = buckets.get(key);
    if(list == null) {
       list = new ArrayList<Human>();
       buckets.put(key,list);
    }
    list.add(human);
}