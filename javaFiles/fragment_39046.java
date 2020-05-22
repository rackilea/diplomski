ArrayList<Food> arrallcomments = mDbHelper.getAllComments();
List<String> strlist = new ArrayList<String>();
for(Food object: list){
  strlist.add("Name : "+object.getName() +
               " Customer :"+object.getCustomer()+...);
 }