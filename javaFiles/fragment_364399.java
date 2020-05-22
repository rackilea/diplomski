@Override
public void onItemClick(AdapterView<?> a, View v, int position, long id) { 
  Object o = lv1.getItemAtPosition(position);
  Recipedetails1 obj_itemDetails = (Recipedetails1)o;
  final Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(o.getUrlWiki()));
  startActivity(i);
}