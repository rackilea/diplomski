gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
   @Override
   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

      /////here i want Toast of catid and catoption.
      String catoption = arrayList.get(position).getCatoption();


   }
});