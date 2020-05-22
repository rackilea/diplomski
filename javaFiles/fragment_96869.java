public static double [] readFile() throws IOException{
     double[] gravity = new double [8]; //size 8 instead of 7  
     Scanner inFile = new Scanner(new File("gravitydata.txt"));
     int count = 0;
     while (inFile.hasNext()){
        double temp = inFile.nextDouble();
        gravity[count] = temp;
        count++;
     }
     inFile.close();
     return gravity;
}

public static double[]calculateWeight(double [] gravity)throws IOException{
   double[] mass = new double[8]; //size 8 instead of 7
   double[] weight = new double[8]; //size 8 instead of 7

   for (int a = 0; a < 8; a++){ //loop 8 times, not 9
     mass[a] = (110*433.59237)/(gravity[a]);
     weight[a] = (mass[a]*gravity[a]);
     //a++; you don't need to increment a here, since it's incremented in the for loop
   }
   return weight;
}

public static void main (String[] args)throws IOException{ 
  printHeading();
  String[] names = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
  //calculateWeight(); no need to call it twice
  double [] gravity = readFile();
  double [] weight = calculateWeight(gravity);          
  for(int y = 0; y < 8; y++)//loop 8 times, not 9
  {
     System.out.printf("%-11s", names[y]);     
     System.out.printf("%13.2f", gravity[y]); 
     System.out.printf("%20.2f\n",weight[y]);
  }
}