String mystr = "";
for(int i = 0; i < personlist.size(); i++) {
  mystr += "\'" + personlist.get(i).firstName + "\'";
  if(i != (personlist.size() - 1)) {
    mystr += ", ";
  }
}