public void set(String element, int position) { 
    element = arrays[arrays.length - 1]; // at this point, you no longer
                                         // know what the element was

    //and now you shift the list by 1 element
    for (int y = arrays.length - 1; y > position; y--)
    arrays[y] = arrays[y - 1];
    arrays[position] = element;
}