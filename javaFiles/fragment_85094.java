public  void  actionPerformed(ActionEvent e)
    {
        if(e.getSource()==jButton2)
                 { 
                    total +=1;
                    jTextField1.setText(""+total);
                 }     
        if(e.getSource()==jButton1)
                 { 
                    total -=1;
                    jTextField1.setText(""+total);
                 }  
      }