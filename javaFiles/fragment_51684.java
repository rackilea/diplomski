ArrayList<ArrayList<Type>> array = new ArrayList<ArrayList<Type>>();    
ArrayList<Type> subList = new ArrayList<Type>();
boolean hasObject = false;
for (int i = 0; i <= array.size(); i++) {
    subList=array.get(i);
    if (subList != null) {
        if (!containsOnlyNull(subList)) return false; //or whatever the semantic is
    }
}       
return true;