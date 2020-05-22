public void refreshBox()
{
    combo.removeAllItems();
    ArrayList<String> list = new ArrayList<String>();
    list.add("godsf");
    list.add("södlkf");
    list.add("ldsjlkfdsj");

    for (String s : list) 
    {
        combo.insertItemAt(s, 0);
    }
}