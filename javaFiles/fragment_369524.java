import userdir.UserClass;

UserClass obj1 =new UserClass(); obj1.method1();

System.setOut(new PrintStream(new BufferedOutputStream(new
FileOutputStream("path/to/file/output.txt")), true));