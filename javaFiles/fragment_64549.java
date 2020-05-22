public String remove(String name) {
    int indx = find(name);
    if(indx < 0)
        return null;
    String num = Directory[indx].getNumber();
    if (indx == Directory.length-1){
        Directory[indx] = null;
        return Directory[indx].getNumber();
    }
    else{
        //Directory is the array holding the class instances.
        for (int i = indx; i < Directory.length-1; i++){
                Directory[i] = Directory[i+1];
        }
        //this return is causing the error. 
        return Directory[indx].getNumber();
    }
    return null;
}