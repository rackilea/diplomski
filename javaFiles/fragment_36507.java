for(String day : allAvailableValues){
    boolean inOld = existingList.contains(day);
    boolean inNew = newList.contains(day);
    if(inOld == false && inNew == false)
        values_not_changed.add(day);
    else if(inOld == true && inNew == false)
        values_to_be_removed.add(day);
    else if(inOld  == false && inNew == true)
        values_to_be_inserted.add(day);
}