public static void main(String[] args) 
{
   // here you are checking for the length of the args array not equal to 1
   // If its not equal to one then, enter the if block
   // To avoid the if block, you need to run the program with exactly 1
   // command line argument
   if ( args.length != 1)
   {
       showUsage();
       System.exit(0);
   }
 ...............

}