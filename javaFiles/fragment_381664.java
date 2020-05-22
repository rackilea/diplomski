public static void main(String[] args) {
     int []count = new int[10];
          Random r = new Random(7); 
          int x=0;
        for (int i = 0; i < count.length; i++)
        {
            x = r.nextInt();
            count[i] = x;

        }
       System.out.println("Max Number :"+maxNumber(count));}//Getting Max Number