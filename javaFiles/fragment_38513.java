String s = "hello";
Class<?> c =  s.getClass();
System.out.println("Name : "+c.getName());
System.out.println("Simple Name: "+c.getSimpleName());
System.out.println("Canonical Name: "+c.getCanonicalName());
System.out.println("Type Name : "+c.getTypeName());