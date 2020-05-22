public boolean allButtonsPressed(){

    for(int i = 0; i < buttonArray.length; ++i){

        if(!buttonArray[i].isPressed()) return false;
    }
    return true;
}