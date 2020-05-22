StringBuilder sb = new StringBuilder();
for (int i = 0; i < listaCompras1.size(); i++){
    sb
      .append(listaCompras1.get(i))
      .append(" - ")
      .append(listaCompras2.get(i))
      .append("\n");
}