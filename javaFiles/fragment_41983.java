//---get all titles---
    db.open();
    Cursor c = db.getAllTitles();
    String text = "";
    if (c.moveToFirst())
    {
        do {          
            DisplayTitle(c, text);
        } while (c.moveToNext());
    }
    db.close();
    Toast.makeText(this, text, Toast.LENGTH_LONG).show(); 
}

public void DisplayTitle(Cursor c, String text)
{
    text +=
            "id: " + c.getString(0) + "\n" +
            "ISBN: " + c.getString(1) + "\n" +
            "TITLE: " + c.getString(2) + "\n" +
            "PUBLISHER:  " + c.getString(3);        
}