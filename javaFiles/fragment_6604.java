int argcount = MOBILENUMBER.size(); // number of IN arguments i.e More than one Mobile number for which you want read SMS

    //  String[] args = new String[]{ 1, 2 };
    StringBuilder inList = new StringBuilder(argcount * list.length);
    for (int i = 0; i < argcount; i++)
    {
        if(i > 0)
        {
            inList.append(",");
        }
        inList.append("?");//This will generate Number of "? " to match our item in array list
    }
    Cursor cur = getContentResolver().query(uri, projection, "address IN (" + inList.toString() + ")" , list, "date DESC ");