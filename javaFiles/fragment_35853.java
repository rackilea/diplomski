public void menuSelected(MenuEvent e) {
   //Make sure jMenu1 and jMenu2 are accessible in here.
   if(e.getSource()==jMenu1)
      operationForMenu1();
   else if(e.getSource()==jMenu2)
      operationForMenu2();
}