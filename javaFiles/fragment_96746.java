A<Integer> obj= new A<Integer> ();

obj.add(1);
obj.add(2);
obj.add(3);
obj.add(4);

Integer[] arr = obj.toArray(Integer.class, obj.size());