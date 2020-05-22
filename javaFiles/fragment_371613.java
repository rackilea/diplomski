public static void swap(int x){
  switch(x){
     case 1:
       clayout.show(bodyPanel, "two");
          panel2.requestFocusInWindow();
          break;
       case 2:
      clayout.show(bodyPanel, "three");
      panel3.requestFocusInWindow();
       break;
       case 3:
       panel3 = null;
      clayout.show(bodyPanel, "four");
      panel4.requestFocusInWindow();
      break;
       case 4:
       panel4=null;
      clayout.show(bodyPanel, "five");
      panel5.requestFocusInWindow();
       break;
     }
  }