public boolean checkForMatch(Button btn2){
    if(color.getCurrentTextColor() == Color.GREEN && btn2.getText().equals("Green"))
        return true;
    else if(color.getCurrentTextColor() == Color.RED && btn2.getText().equals("Red"))
        return true;
    // continue for the rest of the colors
    else 
        return false;
}