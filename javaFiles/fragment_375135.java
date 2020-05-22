for(int i=0; i < Teams.size(); i++){
    if(Teams.get(i).totalDonations() > max){
        max = Teams.get(i).totalDonations(); // always goes for the max team object
        indexOfMax = i;
    }
}