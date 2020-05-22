...
ChildClass.setStaticState(10001);

FileInputStream fi = null;
ObjectInputStream ois = null;
ChildClass streamed;

...
// when de-serializing, the below will print "state101 static state 10001"
System.out.println(streamed.toString());