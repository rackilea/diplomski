myButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ev) {
       buttonWasClicked = true;
    }
});

// within the list listener we do the exact same thing:
if(buttonWasClicked) {
   // for next time...
   buttonWasClicked = false;

   // your event code here for the button, the selected entry is list.getSelectedItem()/Index()
}