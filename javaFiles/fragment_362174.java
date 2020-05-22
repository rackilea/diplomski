Set<Integer> set = new HashSet<>();
set.add(90);
set.add(10);
set.add(20);
set.add(30);

System.out.println(set);
Iterator<Integer> itr = set.iterator();
while(itr.hasNext()){
    Integer ob = itr.next();
    if(ob.equals(30)){
        set.add(11);
    }
}
System.out.println(set);