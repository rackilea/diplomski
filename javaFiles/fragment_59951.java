private int currentVelocityY = 0;
private int gravity = 3;
public void Gravity(){
    this.currentPositionY = this.currentPositionY + this.currentVelocityY;
    if (this.currentPositionY >= 581){
        this.currentPositionY=581;
        this.currentVelocityY = -1 * this.currentVelocityY;
    }
    currentVelocityY = currentVelocityY + gravity;
}