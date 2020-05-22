static int findDistance(int a)
{   
    //variables needed for calculation 
    int temp=a;
    int fact=1;
    int distance=0;
    int shortestDistance=a;
    int lastFact=1;

    while(temp>1)
    {   
        //If value is divisible by fact variable
        if(temp % fact==0)
        {   
            //If last fact does not equal current fact
            if(lastFact!=fact)
            {
            distance=fact-lastFact;
            lastFact=fact;
            }
            //divide by fact
            temp=temp/fact;

            //reassign the fact to 1 so that it can start from beginning
            fact=1;

            //if distance is not zero and shortestDistance is bigger
            if(shortestDistance>distance && distance !=0)
            {   
                //now the shortest distance is the distance
                shortestDistance=distance;
            }
        }

        fact++;
    }
    return shortestDistance;
}