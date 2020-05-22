private void insert(int value) {
    insert(Integer.toString(value));
    ...
    num = Double.parseDouble(str);
}

private void insert(String value) {        
    ...
}

...

public void btndotClicked(View v){
    insert("."); // inserting a String instead of a char
}