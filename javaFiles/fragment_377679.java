// suppose you want to make button 2 visible and hide button 1 in panel 1 on clicking 
//   button  3 from panel 2, you can do something like this:

// add everything you want to display or not in respective panels.
// Then the contents that you dont want to get displayed,make them invisible by calling
   setVisible(false).
// Then for button 3 in panel 2, write actionlistener like this:
     button3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
              // make the visible buttons invisible by using setVisible(false);
              // make the invisible buttons visible by using setVisible(true);
          }
     });