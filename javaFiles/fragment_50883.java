JButton myButton = new JButton();
JTextField myTextField = new JTextField();
JFrame myFrame = new JFrame();

ArrayList<Object> a = new ArrayList<>();
a.add("My String");
a.add(23234);
a.add(376754356L);
a.add(345.74678D);
a.add(3.54f);
a.add(true);
a.add('A');
a.add(myButton);
a.add(myTextField);
a.add(myFrame);

//Ten elements within the Object ArrayList (0-9)
String myString = a.get(0).toString();
int myInt = (int) a.get(1);
long myLong = (long) a.get(2);
double myDouble = (double) a.get(3);
float myFloat = (float) a.get(4);
boolean myBoolean = (boolean) a.get(5);
char myChar = (char) a.get(6);
JButton myNewButton = (JButton) a.get(7);
JTextField myNewTextField = (JTextField) a.get(8);
JFrame myNewFrame = (JFrame) a.get(9);

System.out.println(varType(myString));
System.out.println(varType(myInt));
System.out.println(varType(myLong));
System.out.println(varType(myDouble));
System.out.println(varType(myFloat));
System.out.println(varType(myBoolean));
System.out.println(varType(myChar));
System.out.println(varType(myNewButton));
System.out.println(varType(myNewTextField));
System.out.println(varType(myNewFrame));