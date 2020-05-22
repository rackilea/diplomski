List<Object> itemsToRemove = new ArrayList<Object>();
for (Object x in set)
{
    if (someCondition)
    {
        itemsToRemove.add(x);
    }
}

set.removeAll(itemsToRemove);