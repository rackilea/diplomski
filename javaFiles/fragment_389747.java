public class Robot {
private String name;
private int xPosition;
private int yPosition;
private int totalDistance;

public Robot(){
    name = null;
    xPosition = 0;
    yPosition = 0;
    totalDistance = 0;
}

public Robot(String name, int xPosition, int yPosition, int totalDistance){
    super();
    this.name = name;
    this.xPosition = 0;
    this.yPosition = 0;
    this.totalDistance = totalDistance;
}

public String getName() {
    return name;
}

public void setName( String name){
    this.name = name;
}

public int getxPosition() {
    return xPosition;
}

public void setxPosition(int x) {
    xPosition = x;
}

public int getyPosition() {
    return yPosition;
}

public void setyPosition(int y){
    yPosition = y;
}

public int getTotalDistance() {
    return totalDistance;
}


public void moveX(int distance){
    xPosition += distance;
    totalDistance += Math.abs(distance);
}

public void moveY(int distance){
    yPosition += distance;
    totalDistance += Math.abs(distance);
}