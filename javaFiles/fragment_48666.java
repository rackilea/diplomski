private ObjectSet<Button> toolButtons = new ObjectSet(); //put all buttons into this

//add this same listener to all buttons.
ChangeListener commonListener = new ChangeListener(){
    public void changed (ChangeEvent event, Actor actor){
        for (Button button : toolButtons){
            button.setChecked(button == actor);
        }
        setSelectedTool((Button)actor);
    }
};

void setSelectedTool(Button button){
    //however you are tracking the selected tool, you can apply the change
    //here based on which button was pressed
}

//Also need to set programmatic change events false on all buttons to prevent stack overflow
for (Button button : toolButtons)
    button.setProgrammaticChangeEvents(false);