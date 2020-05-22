for(int i = 0; i < stringArray.length; i++){
    String thisString = stringArray[i];
    ButtonView thisButton = buttonArray[i];
    if(thisString.equals(null)){
        thisButton.setVisibility(View.INVISIBLE);
    }else{
        thisButton.setVisibility(View.VISIBLE);
        thisButton.setText(thisString);
    }
}