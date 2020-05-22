Elements anchorTags = doc.select("table[cellpadding=0][cellspacing=3][border=0] a");
    if(anchorTags.isEmpty())
    {
        System.out.println("Not found");
    }
    else
    {
        System.out.println(anchorTags.first());
    }