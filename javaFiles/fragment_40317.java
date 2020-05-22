IntegerPlus ip1=new IntegerPlus(4,"first");
System.out.println(ip1);

List<IntegerPlus> lipl=new ArrayList<IntegerPlus>();
lipl.add(ip1);
lipl.add(new IntegerPlus(2,"b"));
lipl.add(new IntegerPlus(4,"second"));
lipl.add(new IntegerPlus(1));
lipl.add(new IntegerPlus(3));
lipl.add(new IntegerPlus(5));
lipl.add(new IntegerPlus(6));
lipl.add(new IntegerPlus(4,"third"));
lipl.add(new IntegerPlus(2,"c"));


System.out.println("BEFORE SORT:"+lipl);