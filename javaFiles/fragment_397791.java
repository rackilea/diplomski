String expression = "1+++-3--+++++2";
String[] str = expression.split("[0-9]+");

for(op : str) {
    int count = 0;
    for(int i =0; i < str.length(); i++)
        if(op.charAt(i) == '-')
            count++;

    if(count % 2 == 0) {
        op = "-";
    }
    else {
        op = "+";
    }
}