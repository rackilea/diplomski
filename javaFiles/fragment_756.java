InstanceManager<Object> im = new InstanceManager<Object>();

Object o1 = im.manage(new Object());
Object o2 = im.manage(new Object());

String s1 = im.manage("a");
String s2 = im.manage(new String("b"));

System.out.println("Object count: " + im.getAll(Object.class).size());
System.out.println("String count: " + im.getAll(String.class).size());

o2 = s1 = s2 = null;

System.gc();
Thread.sleep(1000);

System.out.println("Object count: " + im.getAll(Object.class).size());
System.out.println("String count: " + im.getAll(String.class).size());