ContentValues value=new ContentValues();
    value.put("score", curscore); // We want to put curscore in the new row in the score column
    value.put("mode", curmode);
    value.put("diff", curdiff);
    value.put("date", curdate);
db.insert("scoretable",null,value);