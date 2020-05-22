ArrayList<NodoN<T>> postOrder(boolean ignorarRaiz, ArrayList<T> lista){

    for (NodoN<T> nodo: nodos) {            
        nodo.postOrder(false, lista);
    }

    if (!ingnorarRaiz) lista.add(nodo);

    return lista;

}