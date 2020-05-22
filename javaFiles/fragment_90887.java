public void increment(View v) {
    ...
    int t1 = Integer.parseInt(e1.getText().toString());
    e1.setText(String.valueOf(t1+1));
    int t2 = Integer.parseInt(e2.getText().toString());
    e2.setText(String.valueOf(t2+1));
    t1++; t2++; // updating values here
    ....
    mysum=((double)t1/t2)*100;
    ....
}