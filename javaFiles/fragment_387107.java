public void update() {
    this.instanceB = new ClassB(this); // ClassA passes itself
}

public ClassB(ClassA classA) {
    this.classA = classA; // ClassB HAS-A ClassA relationship
    this.tempLong2 = classA.getTempLong() * 2;
}