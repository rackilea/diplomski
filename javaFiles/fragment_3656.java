HashMap<Integer, String> test=new HashMap<Integer, String>();
String s = "String";
System.out.println("Adding with -"+s.hashCode());
test.put(1, s);
test.put(2, "2");
test.put(3, "3");
s = "1";
System.out.println("Modified s-"+s.hashCode());
for (Integer i : test.keySet())
    System.out.println("Key: " + i+ ", Value: " + test.get(i)+"  "+test.get(i).hashCode());
}