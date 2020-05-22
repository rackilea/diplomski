String nullString = null;
System.out.println(nullString);
if (nullString != null) {
    r.putExtra("engsub", item.getSub()); // Normally it shouldn't, but it goes in here
    startActivityForResult(r, position); 
}
else {
    //Do something
}