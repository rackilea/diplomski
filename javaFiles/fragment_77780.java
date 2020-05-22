// Add this field as a flag for you to know whether the sbNationality has been clicked or not.
private Boolean isSbNationalityClicked = false;



// On click, set the flag to true
sbNationality.addListener(new ClickListener(){
    @Override
    public void clicked(InputEvent event, float x, float y){
        isSbNationalityClicked = true;
        super.clicked(event, x, y);
    }
});


addListener(new ClickListsner(){
    @Override
    public boolean keyTyped(InputEvent, char characer){
        // if you caught the keyTyped event and the flag is true - perform your desired action
        if(isSbNationalityClicked){
            auto.CreateAutoComplete(sbNationality, character);
            // set flag to false, since the desired action has been executed
            // you might want to set flag to false in some other cases as well,
            // like mouseReleased or mouseLeave
            isSbNationalityClicked = false;
            return super.keyTyped(event, character);
        }
    }
});