//if(nsrs.next()== true){
//                String [] nsfila = new String[3];

String [] nsfila = null;

while (nsrs.next()) {
    nsfila = new String[3];
    nsfila[0]=nsrs.getString("Numero_Serie");
    nsfila[1]=nsrs.getString("Marca");
    nsfila[2]=nsrs.getString("Gaveta");
    ModeloTablaLista.addRow(nsfila);
}

if (nsfila == null) {
  // no data...
}