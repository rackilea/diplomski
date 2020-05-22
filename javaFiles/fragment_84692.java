for(int row=0; row < card.length; row++){
    while(!valid){
        tmp = (int)(Math.random()*15)+1;
        if(!alreadyUsed.contains(tmp)){
            valid = true;
            alreadyUsed.add(tmp);
        }
    }
    card[row][0]= tmp;
    valid = false;
}