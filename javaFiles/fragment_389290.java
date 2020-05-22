if(!userRatings.containsKey(user)) //The user does not have ratings.
{
   ArrayList<Integer> ratings = new ArrayList<Integer>();                   
   for (int j = 0; j < 50; j++) {
       ratings.add(j);
  }
  userRatings.put(user, ratings); // place new mapping 
  System.out.println(user + " " + userRatings.get(user));
} else //The user has ratings
{
    ArrayList<Integer> ratings  = userRatings.get(user);
    ratings.add(location,value); // Update your list with location and value
    System.out.println(user + " " + userRatings.get(user)); 
}