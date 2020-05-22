if (c.moveToFirst())
    {
        while ( !c.isAfterLast() ){
           dirArray.add( c.getString( c.getColumnIndex("name")) );
           c.moveToNext();
        }
    }