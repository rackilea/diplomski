//in class variables
int maxValue=0;

//method counting progress
public static double countProgress(int particlesRemaining) {

    //???how to set maxValue???
    if(maxValue<particlesRemaining) {
        maxValue=particlesRemaining;}
        double temp = 100 / maxValue * (maxValue - particlesRemaining);
        return temp;
    }
}