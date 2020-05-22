LinkedList<String> werte = new LinkedList<String>();
  if(c.moveToFirst())
    {
        do
        {
            werte.add(c.getString(c.getColumnIndex("fragencount")));
        }while(c.moveToNext());
    }
    c.close();
String size = "" +werte.size();
tv.setText(size);