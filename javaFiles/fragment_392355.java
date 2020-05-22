public boolean isSorted()
{
    boolean sorted = true;        
    for (int i = 1; i < list.size(); i++) {
        if (list.get(i-1).compareTo(list.get(i)) > 0) sorted = false;
    }

    return sorted;
}