private void handleDrag(final JPanel panel){

    panel.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent me) {
             panelY = me.getY();

             panelNo = rowPanel.indexOf(panel);
             tempItem = rowPanel.get(panelNo);

             tempItem.setBackground(panelActiveColor);
             tempItem.setBorder(BorderFactory.createRaisedBevelBorder());
        }

        @Override
        public void mouseReleased(MouseEvent me){

            tempItem.setBackground(panelColor);
            tempItem.setBorder(BorderFactory.createEmptyBorder());
            scroll.revalidate();
        }
    });

    panel.addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent me) {
            me.translatePoint(0, me.getComponent().getLocation().y - panelY);

            int temp;

            if((int) ((me.getY() - panelY) / me.getComponent().getSize().height) < 0){
                temp = 0;
            }
            else if((int) ((me.getY() - panelY) /  me.getComponent().getSize().height) < (elementsAmount - 1)){
                temp = (me.getY() - panelY) /  me.getComponent().getSize().height + 1;
            }
            else{
                temp = (elementsAmount - 1);
            }

            rowPanel.remove(tempItem);

            rowPanel.add(temp, tempItem);

            boxPanel.add(tempItem, temp);

            scroll.revalidate();
        }
    });
}