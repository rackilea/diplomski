public String rellenarCadena(String cadenaParaRellenar, int sizeCadenaTotal){
    int size = sizeCadenaTotal-cadenaParaRellenar.length();
    if(size>0){
        String formato = "%-" + size + "s";
        String rellenar = String.format(formato, " ");
        cadenaParaRellenar = rellenar+cadenaParaRellenar;
    }
    return cadenaParaRellenar;
}