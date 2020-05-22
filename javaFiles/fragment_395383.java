import java.util.*;


public class QueueProgram 
{
    static int[] arrival = {3,3,9};
    static int[] service = {2,15,14};

    int waitTime;
    int finishTime;
    int serviceTime;
    static int index;

    Queue<Integer> Customers = new LinkedList<Integer>();   

    public int maxWait(int[] arrival, int[] service)
    {
        //this.arrival = arrival;
        //this.service = service
        int maxWaitTime = 0;
        int[]finishTime = new int[arrival.length];

        for(int i=0; i<arrival.length;i++)
        {
            int startTime;
            index = i;
            if(index == 0)
            {
                 startTime = arrival[index];
                 //System.out.println(startTime);
            }
            else
            {
                startTime = Math.max(arrival[i],finishTime[i-1]);
            }
            finishTime[i] = startTime + service[i];
            waitTime = finishTime[i] - service[i] - arrival[i];

            if(waitTime > maxWaitTime)
            {
                maxWaitTime = waitTime;
            }
        }
        return maxWaitTime;
    }

    public static void main(String[] args) 
    {
        QueueProgram q = new QueueProgram();
        q.maxWait(arrival, service);
        System.out.println("Maximum wait time is: " + q.maxWait(arrival, service));
    }

}