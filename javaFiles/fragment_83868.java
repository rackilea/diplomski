List<String> list = new ArrayList<String>();
for (String text : array)
{
    if (text != null && text.length() > 0)
    {
        list.add(text);
    }
}
array = list.toArray(new String[0]);