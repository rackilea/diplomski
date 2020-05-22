public int getEntityIndex(String name) { 
    for(int i = 0; i < entities.length; i++){
        if(entities[i].getName().toUpperCase().equals(name.toUpperCase())){
            return i;
        }
    }

    return -1;
}