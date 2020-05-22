testTable.addListener(SWT.PaintItem, new Listener() {

    @Override
    public void handleEvent(Event event) {
        // Am I on collumn I need..?
        if(event.index == 5) {
            Image tmpImage = IMAGE_TEST_PASS;
            int tmpWidth = 0;
            int tmpHeight = 0;
            int tmpX = 0;
            int tmpY = 0;

            tmpWidth = testTable.getColumn(event.index).getWidth();
            tmpHeight = ((TableItem)event.item).getBounds().height;

            tmpX = tmpImage.getBounds().width;
            tmpX = (tmpWidth / 2 - tmpX / 2);
            tmpY = tmpImage.getBounds().height;
            tmpY = (tmpHeight / 2 - tmpY / 2);
            if(tmpX <= 0) tmpX = event.x;
            else tmpX += event.x;
            if(tmpY <= 0) tmpY = event.y;
            else tmpY += event.y;
            event.gc.drawImage(tmpImage, tmpX, tmpY);
        }
    }
});