for (Iterator<Object> iterator = set.iterator(); iterator.hasNext(); )
{
    Object value = iterator.next();
    if (someCondition)
    {
        iterator.remove();
    }
}