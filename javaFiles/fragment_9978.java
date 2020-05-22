boolean prevState;
public void update(...){
    if(Mouse.isButtonDown(0) && !prevState){
        item++;
    }
    prevState = Mouse.isButtonDown(0);
}