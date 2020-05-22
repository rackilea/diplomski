List<String> list = new ArrayList<String>();

System.out.println(list instanceof List<String>);  // Won't compile
System.out.println(list instanceof List);          // You've to do this.

// The reason is, this is true
System.out.println(new ArrayList<String>().getClass() == new ArrayList<Integer>().getClass());   // true