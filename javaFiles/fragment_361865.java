User found;
for (User uid : ulist) {               
  if (userid == uid.getUID()) {
    found = uid;
    break; // assuming that ids are unique
  }
}
if (found != null) {
  System.out.println(found.getUID() +", " + found.getName() +", " + found.getAge() +" years old, " + found.getWeight() +"kg");
} else {
 System.out.println("no data found");
}