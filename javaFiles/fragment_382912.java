Set<Integer> a =  new HashSet<Integer>();

Set<Integer> c = new HashSet<Integer>();

for(int i = 0; i < 10; i++) {
    while (!a.add(rand.nextInt(1001))) // keep trying until we successfully add
        ;
    while (!c.add(rand.nextInt(1001)))
        ;
}