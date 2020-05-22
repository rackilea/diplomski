button.setOnClickListener(new View.OnClickListener() {

   @Override
   public void onClick(View v) {
      // add new row to Adapter
      adapter.addRow(new RowData("0:00"));
   }
});