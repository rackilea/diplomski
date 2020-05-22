System.out.println ("Enter Charecters:");
int count = 0;
String text;
do{
    text = stdin.readLine();
    count += text.length;
} while(!text.endsWith("."));