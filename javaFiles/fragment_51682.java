ArrayList<ArrayList<Type>> array = new ArrayList<ArrayList<Type>>();    
ArrayList<Type> subList = new ArrayList<Type>();
boolean hasObject = false;
for (int i = 0; i <= array.size(); i++) {
    subList=array.get(i);
    if (subList != null) {
        for (Object o : subList) {
            if (o != null)
                        hasObject = true;
            }
        }
    }       
    return hasObject;