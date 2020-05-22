cur.moveToFirst();
if (cur != null) {
    do {    
       sms += "From :" + cur.getString(2) + " : " + cur.getString(11)+"\n";
           Log.i("MyApp", "A " + cur.getString(2) + " " + cur.getString(3));        
    }while(cur.moveToNext());
}