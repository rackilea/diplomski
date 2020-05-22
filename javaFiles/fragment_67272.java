public Car(String name){
    maintenance = false;
    this.name = name;
    for (int i = 0 ; i < this.tires.length ; i++) {
        this.tires[i] = new Tire();
    }
}