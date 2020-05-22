ArrayList<Integer> foo = new ArrayList<Integer>();
foo.add(1);
foo.add(1);
foo.add(2);
foo.add(3);
foo.add(5);
Integer[] bar = foo.toArray(new Integer[foo.size()]);
System.out.println("bar.length = " + bar.length);