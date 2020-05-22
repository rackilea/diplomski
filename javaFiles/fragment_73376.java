//listplaceholder is your layout
//"StoreName" is your column name for DB
//"item_title" is your elements from XML

ListAdapter adapter = new SimpleAdapter(this, mylist, R.layout.listplaceholder, new String[] { "StoreName",
                "City" }, new int[] { R.id.item_title, R.id.item_subtitle });