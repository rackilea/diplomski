public static Node getItem(List <Triple> l, int findRow, int findCol){

    for(int i=0; i < l.size(); i++){
        if(l.get(i).row == findRow && l.get(i).col == findCol){
            return l.get(i).n;
        }
    }
    return null;
}