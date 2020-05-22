tabbedPane.getModel().addChangeListener(new ChangeListener() {
    int lastTabIndex = -1;
    public void stateChanged(ChangeEvent e) {
         int newIndex = tabbedPane.getSelectedIndex();
         if (lastTabIndex == 1 && newIndex == 2) { //or whatever check/combination of checks you would like
             //switched from tab 1 to tab 2!
         }

         //or just check for leaving tab 1
         if (lastTabIndex == 1) {
             //left tab 1!
         }

         //etc

         lastTabIndex = newIndex;
    }
});