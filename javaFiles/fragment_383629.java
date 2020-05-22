public void getYPoints(){
    int counter=0;
    double time=0.0;
    double yCoord=y;
    while(yCoord>=0){
        yCoord=yCoord+(ySpeed*time+0.5*g*time*time);
        yPoints.add(yCoord);
        counter++;
        time+=0.01;
        //System.out.printf("Y coord for time %f is %f and in arraylist is %d\n",time,yCoord,yPoints.get(counter-1));
        this.time=time;
        this.counter=counter;
    }

    //return yPoints;
}
public void getXPoints(){
    double xCoord=x;
    double newTime=0.0;
    while(newTime<this.time){
        xCoord=xCoord+xSpeed*this.time;
        xPoints.add(scale*xCoord);
        newTime+=0.01;

    }