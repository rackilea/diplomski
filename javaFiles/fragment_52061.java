LinkedList<Integer> l1 = new LinkedList<Integer>();
l1.add(1);
l1.add(2);
l1.add(1);
l1.add(4);
l1.add(1);
System.out.println(l1);

HashSet<Integer> set = new HashSet<Integer>();
for (Iterator<Integer> iter = l1.iterator(); iter.hasNext(); ) {
    Integer value = iter.next();
    if (! set.add(value))
        iter.remove();
}
System.out.println(l1);