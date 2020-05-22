StringBuffer sb = new StringBuffer("foo");

List<StringBuffer> list = new ArrayList<StringBuffer>();
list.add(sb);

System.out.println(list);   // prints [foo]
sb.append("bar");

System.out.println(list);   // prints [foobar]

sb = null;

System.out.println(list);   // still prints [foobar]