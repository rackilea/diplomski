public  boolean equalLists(List<String> one, List<String> two){     
    if (one == null && two == null){
        return true;
    }

    if((one == null && two != null) 
      || one != null && two == null
      || one.size() != two.size()){
        return false;
    }

    //to avoid messing the order of the lists we will use a copy
    //as noted in comments by A. R. S.
    one = new ArrayList<String>(one); 
    two = new ArrayList<String>(two);   

    Collections.sort(one);
    Collections.sort(two);      
    return one.equals(two);
}