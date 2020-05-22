public void PrintToUser(String text, int Colour){
    ...
    ...
    Editable CurrentText = MAIN_DISPLAY.getText();
    int oldLength = CurrentText.length();
    CurrentText.append("\n" + text); 

    switch(Colour){
       case 1:
         CurrentText.setSpan(new ForegroundColorSpan(Color.RED), 
                             oldLength, CurrentText.length(), 0); 
       break;
    }
}