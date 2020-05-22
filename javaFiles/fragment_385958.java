timeBefore = System.nanoTime();
            loopCall(timeElapsed);
            timeElapsed =(System.nanoTime()-timeBefore);        
            while(timeElapsed < 5000000){
                timeElapsed = (System.nanoTime()-timeBefore);
            }