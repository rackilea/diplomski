List values=detailDBoperation.getAllDetails();
 List<String> names=new ArrayList<String>();
 for(int i=0;i<values.size();i++)
 {
   names.add(values.get(i).getName()); 
 }
 ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,names);