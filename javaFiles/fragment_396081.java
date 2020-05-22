SharedPreferences.Editor editor = getSharedPreferences("YourListName", MODE_PRIVATE).edit();
for(int i = 0; i < YOUR_LIST.count() ; i++){
    Point p = YOUR_LIST.get(i);
    editor.putInt("Element" + i + " X", p.x);
    editor.putInt("Element" + i + " Y", p.y);
}
editor.commit();