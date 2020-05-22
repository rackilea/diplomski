ChangeListener changeListener = new ChangeListener (){
    public void changed (ChangeEvent event, Actor actor) {
        if (actor == button1) doButton1Action();
        else if (actor == button2) doButton2Action();
        else if (actor == button3) doButton3Action();
    }
}