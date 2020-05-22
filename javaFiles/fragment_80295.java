ArrayList <Integer> randomized = new ArrayList <Integer> ();  

 randomized.add(new Integer(1));
 randomized.add(new Integer(2));
 randomized.add(new Integer(3));
 randomized.add(new Integer(4));
 randomized.add(new Integer(5));
 randomized.add(new Integer(6));
 randomized.add(new Integer(7));
 randomized.add(new Integer(8));
 randomized.add(new Integer(9));
 randomized.add(new Integer(10));

Collections.shuffle(randomized);
System.out.println(randomized);