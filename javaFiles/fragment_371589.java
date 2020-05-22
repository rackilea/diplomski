public List<UnidadOrganicaArbol> collectToList(UnidadOrganicaArbol arbol) {
    List<UnidadOrganicaArbol> result = new ArrayList<>();
    result.add(arbol);
    UnidadesOrganicasArbol children = arbol.getUnidadesOrganicasArbol();
    if (children != null) {
        for (UnidadOrganicaArbol child : children.getUnidadOrganicaArbol()) {
            result.addAll(collectToList(child));
        }
    }
    return result;
}