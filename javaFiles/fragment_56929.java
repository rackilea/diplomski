Scanner s = new Scanner(System.in);
int r;
String c;
String h, v;

// Get input from the user.
System.out.println("Please enter the number of rows for the rectangle.");
r = s.nextInt();
System.out.println("Please enter a character for the rectangle.");
c = s.next();

// Make the box's lines.
h =     new String(new char[r  ]).replace("\0",  c);
v = c + new String(new char[r-2]).replace("\0", " ") + c;

System.out.println(h);
for (int i=r-2; i>=1; --i) {
    System.out.println(v);
}
System.out.println(h);