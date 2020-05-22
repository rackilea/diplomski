public boolean eat() throws Exception{
    if(hive.takeHoney(2)){
        if(health < 3){
            health++;
        }
        return true;
    }
    health -= 1;
    if(health == 0){
        throw new BeeOutOfHealthException(); 
    }
    return false;
}