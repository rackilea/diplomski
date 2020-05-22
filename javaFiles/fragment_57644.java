public void addRow(RowData newRow) {
   // items represents List<RowData> in your Adapter class
   this.items.add(newRow);

   // sends request to update ListAdapter
   notifyDataSetChanged();
}