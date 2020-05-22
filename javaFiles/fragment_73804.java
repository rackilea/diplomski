String text = "ID     SALARY RANK\n" +  
            "065    12000   1\n" +
            "023    15000   2\n" +
            "035    25000   3\n" +
            "076    40000   4\n";

Scanner scanner = new Scanner(text);

//reading the first line, always have header
//I suppose
String nextLine = scanner.nextLine();
//regex to break on any ammount of spaces
String regex = "(\\s)+";


String[] header = nextLine.split(regex);

//this is printing all columns, you can 
//access each column from row using the array
//indexes, example header[0], header[1], header[2]...
System.out.println(Arrays.toString(header));

//reading the rows
while (scanner.hasNext()) {
    String[] row = scanner.nextLine().split(regex);

    //this is printing all columns, you can 
    //access each column from row using the array
    //indexes, example row[0], row[1], row[2]...
    System.out.println(Arrays.toString(row));
    System.out.println(row[0]);//first column (ID)
}