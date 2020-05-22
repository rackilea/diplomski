int i = 0;
while (i < a.length()) {
    look at a.get(i);
    ... see if you want to remove the element
    if (you want to remove the element) {
        call method to delete element from array;
    } else {
        i++;
    }
}