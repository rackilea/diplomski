public void checkPlate(){
    while(!Producer.finished)
    //System.out.println(this.name + " checks the plate for pancake");
    synchronized (Producer.plate){
        Boolean isEmpty = Producer.plate.isEmpty();
        if ( isEmpty == false){
        System.out.println(this.name + " grabs a pancake");
        Producer.plate.pop();
        eat();
        this.eatenPancakes +=1;
        }
    }
    try {
        Thread.sleep(200);// waits since theres no pancake
    } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
    }
}
}