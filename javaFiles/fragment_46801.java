List<String>selectedValues = new ArrayList<String>();

List<String> selected = jList1.getSelectedValuesList();
//List to hold selected values. 
selectedValues.addAll(selected);    

jList2.setListData(selectedValues.toArray(new String[0]));

List<String>remainingValues = new LinkedList<>();
for(int index=0; index<jList1.getModel().getSize(); index++){
    String str = jList1.getModel().getElementAt(index);
    if( ! selectedValues.contains(str)){
        remainingValues.add(str);
    }
}
//getRemainingValuesList() returns the values remaining after selection
jLis1.setListData(remainingValues);