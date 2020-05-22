ContentType content = x.addNewContent();
    content.setType("none");

    XmlCursor cur = null;
    try
    {
        cur = content.newCursor();
        cur.toFirstContentToken();
        cur.insertChars("Hello World");
    }
    finally
    {
        cur.dispose();
    }