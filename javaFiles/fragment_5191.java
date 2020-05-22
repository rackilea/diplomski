String[] a = new String[] {"quick", "brown", "fox"};

List<String> s = new ArrayList<String>(Arrays.asList(a));
s.add("jumps");
a = s.toArray(new String[s.size()]);

System.out.println(Arrays.toString(a));