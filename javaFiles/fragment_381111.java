int[] indexoptio;
indexoptio = this.list_optio.getSelectedIndices();

for (int i=0 ; i<indexoptio.length ; i++) {
    this.optio.remove(indexoptio[i]-i);
}
this.list_optio.setModel(optio);