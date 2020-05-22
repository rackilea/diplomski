Sack<Integer> s = new Sack<Integer>();
Integer i       = new Integer(2);

s.add(new Integer(1)); //<- Error
s.add(i);              //<- Error
s.add(3);              //<- Error
s.add(4);              //<- Error
s.add(5);              //<- Error
s.add(6);              //<- Error

System.out.println("Size: " + s.size() + " Contains: " + s.contains(5));