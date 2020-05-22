if(uas.size() > 0 && tinydb.getInt("selectedUA", 0) == position) {
       item.setBackgroundColor(Color.GREEN);
 } else {
       // e.g.
       item.setBackgroundColor(Color.RED);
 }