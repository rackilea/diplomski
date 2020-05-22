Intent startfavs = (new Intent(Insulter.this, Favorites.class));
String[] objects = new String[set.size()];
set.toArray(objects);
final ArrayList<String> list = new ArrayList<String>(Arrays.asList(objects));
startfavs.putStringArrayListExtra("favs",list);
startActivity(startfavs);