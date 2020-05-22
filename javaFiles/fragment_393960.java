File x = new File("C:", "Workspace"); 
System.out.println(x.isAbsolute()); // not absolute according to the spec

File xx = new File("C:\\", "Workspace");
System.out.println(xx.isAbsolute());

File xxx = new File("\\\\Workspace");
System.out.println(xxx.isAbsolute());