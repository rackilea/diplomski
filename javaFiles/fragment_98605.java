list = new ArrayList<String>();
list.add("Dog");
list.add("Cat");
...
//or alternatively list.addAll(Arrays.asList(normalArray)); if you have your data in array

Collections.shuffle(list,new Random(System.nanoTime()); //randomly shuffles your list