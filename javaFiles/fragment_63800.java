public int find(String name){
    for (int x=0; x < theDirectory.length; x++){
        if (theDirectory[x].getName() != null && theDirectory[x].getName().equals(name)){
            return x;
        }
    }
    return  -1;
}