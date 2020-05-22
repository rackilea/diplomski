User user = ...; //an instance of User
 Map<String, List<User>> userCityMap = new HashMap<String,List<User>>(); 
 List<User> userWithThatCity = map.get(user.getCity());
 if(userWithThatCity == null)
 {
   userWithThatCity = new ArrayList<User>();
   userCityMap.put(user.getCity(), userWithThatCity);
 }
 userWithThatCity.add(user);
 ...