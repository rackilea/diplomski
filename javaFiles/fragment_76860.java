final int itr = i;
imageButtonup[i].setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        int index = itr < outletnametxt.length ? itr+1 : itr;
        String val = outletnametxt[index].getText().toString();//index of text value to get value from
        outletnametxt[index].setText(outletnametxt[itr].getText().toString());
        outletnametxt[itr].setText(val);
    }
});


imageButtondown[i].setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        int index = itr > 0 ? itr-1 : itr;
        String val = outletnametxt[index].getText().toString();
        outletnametxt[index].setText(outletnametxt[itr].getText().toString());
        outletnametxt[itr].setText(val);
    }
});