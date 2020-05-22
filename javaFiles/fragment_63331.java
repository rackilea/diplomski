String evStr=new String();
String odStr=new String();

int curNum=0;
for (int i = 0; i < antal; i++) {
    curNum = (int) (Math.random() * 999 + 1);

    System.out.print(curNum + " ");
    if ((curNum % 2) == 0) {
        evStr+=" "+curNum;
        evenCounter++;
    }
    else {
        odStr+=" "+curNum;
        oddCounter++;
    }
}
System.out.println();
System.out.println("These "+evenCounter+" numbers are even: "+evStr);
System.out.println("These "+oddCounter+" numbers are odd: "+odStr);