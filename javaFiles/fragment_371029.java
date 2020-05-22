NodeList idlist = doc.getElementsByTagName(KEY_ID);
    NodeList namelist = doc.getElementsByTagName(KEY_NAME);
    NodeList costlist = doc.getElementsByTagName(KEY_COST);
    NodeList desclist = doc.getElementsByTagName(KEY_DESC);
    for (int i=0; i<idlist.getLength(); i++)
    {
        Item item = new Item();
        item.setCost(costlist.item(i).getTextContent());
        item.setDescription(desclist.item(i).getTextContent());
        item.setName(namelist.item(i).getTextContent());
        itemarray.add(item);

    }