public static int findCandyBar(ArrayList<CandyBar> list, String n)
{ 
    for(int i = 0; i < list.size(); i++){
        if(list.get(i).getName().equals(n)){
            return i;
        }
    }
    return -1;
}