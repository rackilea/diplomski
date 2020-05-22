Scanner scan=new Scanner(System.in);
String line;
int count=1;
boolean docontinue = true;
while (docontinue){
    line=scan.nextLine();
    if (line.equals(" ")){
        docontinue = false;
        System.out.println("break");
    }
    System.out.println(line);
    System.out.println(count);
    count=count+1;
}