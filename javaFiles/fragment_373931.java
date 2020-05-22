@Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnA:
                 letter += "A";
                 checkCombo(letter);  
                 break;
            case R.id.btnB:
                 letter += "B";
                 checkCombo(letter);  
                 break;
            .
            .