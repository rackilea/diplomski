List<Object> array = new ArrayList<Object>();
StringBuilder a = new StringBuilder("xxxxxx");
array.add(a);

a.setLength(0);  // clear the contents

System.out.println(array.get(0));  // will not print "xxxxxx" anymore