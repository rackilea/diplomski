for(int i = 0; i < imageInByte.length; i++){
        if(i % 4 == 0){
            change = !change;
        }
        if(change){
            high[highC] = imageInByte[i];
            highC++;
        } else {
            low[lowC] = imageInByte[i];
            lowC++;
        }
    }