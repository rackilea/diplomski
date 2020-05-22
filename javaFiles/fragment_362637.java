synchronized public static void finished(Thread winner){
    if(winner.isInterrupted()) {
        // sorry, the other thread beat you here
        return;
    }

    if (winner.getName().equals("Hare")) tortoise.interrupt();
    else if (winner.getName().equals("Tortoise")) hare.interrupt();    
}