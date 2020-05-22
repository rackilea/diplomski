// checks for value in between 0 to 100 excluding 0 and 100
if (threatLevelEnd  > 0 && i<100) 
    System.out.println("WARNING");
// checks for value in between 100 to 200 excluding 100 and 200
if (threatLevelEnd > 100 && threatLevelEnd < 200) 
    System.out.println("SEVERE");
// checks for value greater than 200
if (threatLevelEnd > 200)
    System.out.println("CRITICAL");
else 
// if value is not grether than 200
     System.out.println("ERROR");