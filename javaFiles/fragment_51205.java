long timeStamp = 1375715967249l;
    long currTime = System.currentTimeMillis();
    if ((currTime - timeStamp) > 10*60*1000) {
        System.out.println("Greater than 10 minutes since executed");
    } else {
        System.out.println("Lesser than 10 minutes since executed");
    }