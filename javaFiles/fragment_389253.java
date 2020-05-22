public static void main(String[] args) throws FileNotFoundException {
    String file = "inputt.txt";
    Scanner scan = new Scanner(new File(file)).useDelimiter("\\s+");
    /** One segment of record as parsed by scanner.
    TOKENS                  Index
    kv                      0
    {                       1
    key                     2
    "prefix"                3
    str_value               4
    "prefix1"               5
    }                       6
    */
    int tokenCount=0;
    int index1=3; 
    int index2=5;
    while (scan.hasNext()) {
       String str=scan.next();
       if(tokenCount%7==index1){
           System.out.print(str);
       }   
       if(tokenCount%7==index2){
           System.out.println("  "+str);
       }
       tokenCount++;
    }
    scan.close();
 }