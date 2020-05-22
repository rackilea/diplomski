if(!mapParentAndChildLines.containsKey(parentLineNo)){

    // Create a new list to add in the map
    lsChildLine = new ArrayList();
    lsChildLine.add(childLine);

    mapParentAndChildLines.put((parentLineNo), lsChildLine);

}else{

    lsChildLine =  mapParentAndChildLines.get(parentLineNo);
    lsChildLine.add(childLine);

    // Unnecessary, the list is already in the map
    // mapParentAndChildLines.put((parentLineNo), lsChildLine);

}