boolean waiting = false;
long tWaitStart;
Runnable trueKeyListener = new Runnable(){
    @Override
    public void run(){
        while(true){//Instead of true, use some variable, like running
            if(aPressed){
                aTruePressed = true;
            }else if(!waiting){//not yet waiting for the 15 ms
                waiting = true;
                tWaitStart = System.nanoTime();
            }else if(System.nanoTime() - tWaitStart >= 15000000){//waiting is over
                waiting = false;
                if(!aPressed){//a still isn't pressed
                    aTruePressed = false;
                }
            }
        }
    }
};