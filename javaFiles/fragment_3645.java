double lastVal = -1.0;
    for(int i=0;i<4;i++){
        if (coin[i] == coin [i+1] && lastVal != coin[i]) {  // prevent reading same value
            lastVal = coin[i];
            if(coin[i] == .25) 
                System.out.println("quarter is repeated");
            if(coin[i] == .10) 
                System.out.println("dime is repeated");
            // etc

            i++;
        }
    }