public class Assignment3Q1 {
   public static void main(String[] args)
    {
        Random darts = new Random();
        int sum=0;
        int tosses=0;
        int multiplier[] = {7, 5, 5, 5, 3, 3, 3, 1, 1, 1};
        do
        {
            int [] timesHit = new int [10];
            int [] points = new int [10];
            tosses = 0;
            sum = 0;
            for ( int i = 0; i < timesHit.length; i++)  
            {
                timesHit[i]= 20 + darts.nextInt(20);
                points[i] = timesHit[i] * multiplier[i];
                tosses += timesHit[i];
                sum += points[i];
            }
        } while (sum<1000);
        System.out.println("Final Tosses="+tosses);
        System.out.println("Final Sum="+sum);
    }

}