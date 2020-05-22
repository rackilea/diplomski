// ...... your other codes
 for (int i = 0; i < ficheros.length; i++) {
  dataModels.add(new DataModel(ficheros[i], fecha[i]));
}

// here you can sort your list like the following
Collections.sort(dataModels, new Comparator<DataModel>(){
    public int compare(DataModel lhs, DataModel rhs){
      return lhs.getFicheros().compareTo(rhs.getFicheros());
    }
});

adapter= new CustomAdapter(dataModels,getApplicationContext());

list2.setAdapter(adapter);