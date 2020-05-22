char x;
if(list.isEmpty()) {
    //undefined
    x = '\0';
} else {
    //our function
    x = (char) ('a' + list.size() - 1);
    if(x > 'z') {
        //undefined
        x = '\0';
    }
}