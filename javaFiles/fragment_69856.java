static void imprimirNodo(ListaEnlazada1 nodo) {
    System.out.println("----------");
    System.out.println("Marca: " + nodo.marca); // No need to break the line manually.
    System.out.println("Kilometraje: " + nodo.kilometraje);
    /* Note that printing nodo.nodosiguiente may lead to
    * unreadable output unless you override toString() */
    System.out.println("Apuntador: " + nodo.nodosiguiente);
}