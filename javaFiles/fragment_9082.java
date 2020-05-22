public void characters(char ch[], int start, int length) {
    String theString = new String(ch, start, length);

    switch (currentstate) {
    case RSS_TITLE:
        _item.setTitle(theString);
        // currentstate = 0;
        break;
    case RSS_LINK:
        _item.setLink(theString);
        // currentstate = 0;
        break;
    case RSS_DESCRIPTION:
        _item.setDescription(theString);
        // currentstate = 0;
        break;
    case RSS_CATEGORY:
        _item.setCategory(theString);
        // currentstate = 0;
        break;
    case RSS_PUBDATE:
        _item.setPubDate(theString);
        // currentstate = 0;
        break;
    default:
        return;
    }