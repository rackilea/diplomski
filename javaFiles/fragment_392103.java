public boolean overlap(int targetX, int targetY){
    double x=this.getX();
    double y=this.getY();
    double deltaX = Math.abs(targetX-x);
    double deltaY = Math.abs(targetY-y);

    return (deltaX<=16 && deltaY<=16);       
}