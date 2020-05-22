String[] from = { "title", "url" };
int[] to = { android.R.id.text1, android.R.id.text2 };

SimpleAdapter adapter = new SimpleAdapter(this, data, android.R.layout.simple_list_item_2,
from, to);
lvList.setAdapter(adapter);