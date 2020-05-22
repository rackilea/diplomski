Scanner keyboard = new Scanner(System. in );

String wrd1 = keyboard.next();
String wrd2 = keyboard.next();
String wrd3 = keyboard.next();

int num1 = 0;
int num2 = 0;
int num3 = 0;

//BREAK ---------------  

while (usConst.hasNext()) {
    String check = usConst.next();

    if (check.equals(wrd1)) {
        num1++;
    } else if (check.equals(wrd2)) {
        num2++;
    } else if (check.equals(wrd3)) {
        num3++;
    }
}
System.out.print("The word " + wrd1 + " shows up " + num1 + " times in the file!");