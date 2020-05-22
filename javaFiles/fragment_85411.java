ClickListener clickListener = new ClickListener (){
    public void clicked(InputEvent event, float x, float y){ 
        Actor actor = event.getListenerActor();
        if (actor == button1) doButton1Action();
        else if (actor == button2) doButton2Action();
        else if (actor == button3) doButton3Action();
    }
}