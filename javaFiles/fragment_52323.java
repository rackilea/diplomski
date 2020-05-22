Field[] fields = R.raw.class.getFields();
ListView list;
String sample[] = new String[R.raw.class.getFields().length];
int count=0;
 for(Field f : fields)
 {
     sample[count]=f.getName();
     count++;
 }

list=getListView();
list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
setListAdapter(new ArrayAdapter<String>(this,
android.R.layout.simple_list_item_checked, sample));