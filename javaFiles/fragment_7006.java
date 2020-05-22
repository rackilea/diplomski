//The following for loop is likely the cause
    for(int i = 0; i< bullets.size(); i++){ 
        if(bullets.get(i).remove){
            bullets.remove(i); // <-- this is the problem 
        }
    }