public int calculateSleeptime(int px, int py, int x, int y){
    int distance = (y-py)*(y-py)+(x-px)*(x-px);
    distance = (int)(Math.sqrt(distance);
    int sleepTime = distance*100; //play with this value!
    return sleeptime;
}