int x = 0;
while (x < 5) {
   int noun = (int)(Math.random() * n.size());
   int verb = (int)(Math.random() * v.size());
   int noun2 = (int)(Math.random() * n.size());
   int verb2 = (int)(Math.random() * v.size());
   int noun3 = (int)(Math.random() * n.size());
   String a = new String(n.get(noun) + " " + v.get(verb) + " " + n.get(noun2)   + " " +  "and" + " " + v.get(verb2) + " " + n.get(noun3));
   System.out.println(a);
   x++;
 }