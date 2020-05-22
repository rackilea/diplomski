public static void main( String[] args)  { 
     Field f1 = new Field("Free from debris..." , 0.15d, 2.0d);
     Field f2 = new Field("Level of street noise..." , 0.09d, 3.0d);
     Field f3 = new Field("Overall safe..", 0.24d, 1.0d);  

     System.out.println("Total score for all fields : ");
     System.out.println(f1.getFinalScore() + f2.getFinalScore() + f3.getFinalScore());
}