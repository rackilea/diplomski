ArrayList<String> lista = new ArrayList<String>();

ArrayList<String> lista1 = new ArrayList<String>();
ArrayList<String> lista2 = new ArrayList<String>();
ArrayList<String> lista3 = new ArrayList<String>();

ArrayList<String>[] newLists = new ArrayList[]{lista1, lista2, lista3};
for (int i=0 ; i< lista.size(); i ++ ){
  newLists[i % 3].add(lista.get(i)); 
}