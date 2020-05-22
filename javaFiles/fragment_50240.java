//distance of the current circle from the viking
int tempCircleDistance = 0;

//the minimum distance we have found so far in our loop
int minCircleDistance = 0;

//index of the min circle we have found so far
int indexOfNearest=0;

for(int i = 0; i<circlesOnTheField; i++) 
{
        //help me Phytagoras
        tempCircleDistance = (int) (Math.sqrt((viking.getX() - circles[i].getX())*
                                              (viking.getX() - circles[i].getX())+
                                              (viking.getY() - circles[i].getY())*
                                              (viking.getY() - circles[i].getY()))-
                                              (viking.getR() + circles[i].getR()));

        //first cycle or did we find the nearest circle? If so update our variables
        if(i==0||tempCircleDistance<minCircleDistance)
        {    
               indexOfNearest=i;
               minCircleDistance=tempCircleDistance;
        }
}

//draw the line with the given index of the nearest circle
canvas.drawLine(viking.getX(), viking.getY(), 
                circles[indexOfNearest].getX(), 
                circles[indexOfNearest].getY(), 
                pgoal);