if (h > first) 
        quickSort(list, first, h);
    if (g < last) 
        quickSort(list, g, last);      
}

private static void swap (ArrayList <String> list, int first, int h)
{
    String temp = list.get(first);
    list.set(first, list.get(h));
    list.set(h, temp);
}