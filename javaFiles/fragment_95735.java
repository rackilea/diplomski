/**
     * Called internally to popup the dates.
     */
    private void showPopup() {
        // This is the replaced code:
//      if (popup == null){
//          PopupFactory fac = new PopupFactory();
//          Point xy = getLocationOnScreen();
//          datePanel.setVisible(true); 
//          popup = fac.getPopup(this, datePanel, (int) xy.getX(), (int) (xy.getY()+this.getHeight()));
//          popup.show();
//      }
        // This is new code
        JPopupMenu pop = new JPopupMenu();
        pop.add(datePanel);
        pop.show(this, this.getX(), this.getY() + this.getHeight());
    }