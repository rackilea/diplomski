int i = 1;
java.util.List<String> items = new ArrayList<String>();
while(r.next()){
    items.add(r.getString("item_name")); // Add all items to List
    if(i >= 3){
         TableModel2.addRow(items.toArray(new String[items.size()])); // Convert the List to array and add it to the row
         items = new ArrayList<String>();
         i = 1;
    }
    i++;
}
if(items.size()>0)
   TableModel2.addRow(items.toArray(new String[items.size()])); // Adding the rest items to the last row.