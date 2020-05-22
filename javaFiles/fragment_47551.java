LinkedList<Integer> l = new LinkedList<Integer>();
l.add(Integer.valueOf(2));
l.add(Integer.valueOf(0));
l.add(Integer.valueOf(3));
for(int j=0;j<p.length;j++)
//it will be the same LinkedList<Integer> l per all the instances in the array
    p[j] = new link(l);