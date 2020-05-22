char c;
Scanner scaner = new Scanner(System.in);

// Storing scanned value
String nextStr = scaner.next();

int length = nextStr.length();
System.out.println(length);

int i = 0;
while(i < length){
    c = nextStr.charAt(i);
    System.out.println(c);
    i++;
}