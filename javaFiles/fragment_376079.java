yourJpanel.setDropTarget(new DropTarget() {

    @Override
    public synchronized void drop(DropTargetDropEvent dtde)
    {
        this.changeToNormal();
        //handle the drop ....
    }

    @Override
    public synchronized void dragEnter(DropTargetDragEvent dtde){

        //Change JPANEL background...
        yourJpanel.setBackground(Color.RED);
    }

    @Override
        public synchronized void dragExit(DropTargetEvent dtde) {
        this.changeToNormal();
    }

    private void changeToNormal() {   
        //Set background to normal...
        yourJpanel.setBackground(Color.WHITE);
    }
});