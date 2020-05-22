for (int i = 0; i < values.length; i++) {
    if(values[i] == itemvalue)
    {
            ID = i;
        }
}
Toast.makeText(getApplicationContext(),"Position :"+ID+"  ListItem : " +itemvalue , Toast.LENGTH_LONG).show();