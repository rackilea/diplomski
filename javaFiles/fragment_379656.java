public int goals(){
    int total = 0;
    for(Player p : list){ // for each Player p in list         
       total += p.goals();
    }       
    return total;
}