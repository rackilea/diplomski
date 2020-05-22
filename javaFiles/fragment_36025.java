private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
   //my code here to set text and background etc
   if(jButton3.getActionCommand().equals("X") && jButton1.getActionCommand().equals("") && jButton2.getActionCommand().equals("")){
             Random rand_gen = new Random();
             int index_selected = rand_gen.nextInt(unmarked_boxes.size());
             box_selected = unmarked_boxes.remove(index_selected);
             /*
             here you select and mark the button which corresponds to the box 
             selected. i.e. if the box_selected = 3, then find and mark button3 (not sure 
             how you access your buttons).
             */
    }