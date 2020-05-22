addStringForIndex(String string, Integer index)
{
    listForString = stringMap.get(index);
    if(listForString == null) {
        listForString = new ArrayList<String>;
        map.put(index, listForString);
    }
    listForString.add(string);
}