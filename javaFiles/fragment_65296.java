private RoomDimension size;
private double carpetCost;

public RoomCarpet (double cost){
    carpetCost = cost;
}

public RoomCarpet (double cost,RoomDimension size){
    carpetCost = cost;
    this.size = size;
}

public void setCarpetCost(double cost){
    carpetCost = cost;
}

public double getCarpetCost(){
    return carpetCost;
}

public RoomDimension getSize() {
    return size;
}

public void setSize(RoomDimension size) {
    this.size = size;
}

public double getTotalCost(){
    if(size != null) {
        return size.getArea() * carpetCost;
    }
    else {
        System.out.println("error size is not define");
        return 0;
    }
}

public String toString(){
    String str = "\nYour total area for your room is " + size.getArea()
            + "\nThe cost of your carpet per square foot is " + carpetCost;

    return str;
}