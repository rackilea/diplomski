public class Car extends MoveableObject{
    private int height;
    private int width;

    public Car(){
        super.setX(200);
        super.setY(2);
    }

    public Car(int x, int y){
       super.setX(x);
       super.setY(y);
    } 

}