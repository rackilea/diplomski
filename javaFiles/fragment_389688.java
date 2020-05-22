try {
   // you can sort your list  by date like the following
  Collections.sort(dataModels, new Comparator<DataModel>(){
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

      public int compare(DataModel lhs, DataModel rhs){
        try{
           return dateFormat.parse(lhs.getFecha()).compareTo(dateFormat.parse(rhs.getFecha()));
        }catch (Exception e) {
            // handle your exception here.
            Log.e("TAG", "Exception : "+e.toString());
            return 0;
        }
      }
  });
}