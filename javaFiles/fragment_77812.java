Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();
while (itr.hasNext())
{
    Map.Entry<String, String> pair = itr.next();
    if (yourCriteriaIsMet)
    {
        itr.remove();
    }
}