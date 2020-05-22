List<Integer> list = new ArrayList<>();
Scanner sc = new Scanner(System.in);
System.out.print("give me some numbers: ");
String numbersInLine = sc.nextLine();//I assume that line is in form: 1 23 45 

Scanner scLine = new Scanner(numbersInLine);//separate scanner for handling line
while(scLine.hasNextInt()){
    list.add(scLine.nextInt());
}
System.out.println(list);