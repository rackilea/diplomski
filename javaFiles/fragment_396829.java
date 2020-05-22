public void set(String element, int position) {
    String tmp = arrays[position];
    arrays[position] = element;
    ...
    ... //here check if element you have set was already inside the array
    ... //if it isn't, increase array length and put tmp at the end
    ... //if it is, put tmp in old index of element
}