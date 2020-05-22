TextClick click=new TextClick();
 for (int i = 0; i < x; i++) {
    TextHolder firstOne = genList.get(i);
    String text = firstOne.getText();
    mainText[i] = new TextView(this);      
    mainText[i].setOnClickListener(click);
    ...
 }