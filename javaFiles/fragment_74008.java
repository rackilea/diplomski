ArrayList<Integer>  lista = new ArrayList<Integer>();
lista.add(159);
lista.add(170);
lista.add(256);

Random r = new Random();
System.out.println(lista.get(r.nextInt(lista.size())));