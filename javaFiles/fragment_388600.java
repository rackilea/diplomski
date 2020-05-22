private ColorButton colorButton0;
private ColorButton colorButton1;
//etc.

private EventListener colorButtonListener = new EventListener(){
    public boolean handle (Event event){
        Actor actor = event.getTarget();
        if (actor == colorButton0)
            //do something
        else if (actor == colorButton1)
            //do something
        else
            return false;
        return true;
    }
}