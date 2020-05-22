for(String mob : mobInstanceMap.keySet()){
    String mobName = mob;
    int lastWalkTime = mobInstanceMap.get(mob);
    int mobWalkSpeed = 4000;
    long walkWaitTime = lastWalkTime;
    long elapsedTime = (long) ((System.nanoTime() - entityMovementLoopStartTime) / 100.0);
    walkWaitTime += elapsedTime;

    if (walkWaitTime >= mobWalkSpeed){
        System.out.println("Wasted time(walking)(" + mobName + "): " + (walkWaitTime - mobWalkSpeed));

        mobInstanceMap.put(mobName, 0);
    } else {  //!(walkWaitTime >= walkSpeed)
        mobInstanceMap.put(mobName, (int) walkWaitTime);
    }
}