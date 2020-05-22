public static void main(String [] args) {
     double average = 0.0;
     double sum = 0;
     int i =0;
     int num = 0;
     int nElements = 0;
     Scanner console = new Scanner(System.in);

     ArrayList<Integer> value = new ArrayList<Integer>();

     System.out.println("Enter value: ");
     num = console.nextInt();

     while(num != 0) {
         value.add(new Integer(num));
         num = console.nextInt();
     }

     for(i = 0; i < value.size(); i++) {
         sum += value.get(i);
     }
     average = sum / value.size();
     System.out.println("Number of values read: " + value.size());
     System.out.println("Values sum: " + sum + " Values average: " + average);
     System.exit(0);
}