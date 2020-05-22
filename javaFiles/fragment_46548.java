Map<String,Integer> dayValues = new HashMap<>();
dayValues.put("Monday",1);
...
dayValues.put("Sunday",7);
Comparator<String> cmpDays = Comparator.comparing(dayValues::get);
...
Map<String, Collection<UserHistoryDto>> map = new TreeMap<>(cmpDays);