public class Bug {
private int position;
private int diff = 1;

public Bug(int position){
    this.position = position;
}
public void turn(){
    if(diff == 1){
       diff = -1;
    } else {
       diff = 1;
    }
}
public void move(){
    position += diff;

}
public int getPosition(){
    return position;
}  
}