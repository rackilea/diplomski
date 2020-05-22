Iterator<Cliente> i = cliente.iterator();
Iterator<Articulo> j = articulo.iterator();

while (i.hasNext() && j.hasNext()) {
    System.out.println(i.next());
    System.out.println(j.next());
}