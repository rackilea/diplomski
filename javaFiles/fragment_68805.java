public void randomgenerator(int j)
{
for(j=0; j<=99; j++){
    if(j >= 1){
        if (randomset.get(j) == randomset.get(j-1)){
            randomset.add(0 + ( j  ,  int)(Math.random() * ((99 - 0) + 1)));
        }
        else{
            randomset.add(0 + (int)(Math.random() * ((99 - 0) + 1)));
        }
    }
    else {
           randomset.add(0 + (int)(Math.random() * ((99 - 0) + 1)));
    }       
}