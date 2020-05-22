//     inside your JFrame constructor().
                  JFrame()
                  {  
                      initComponents();
                      customLabel();
                  }
                   private void customLabel()
                  {
                  // your own custom code...
                  Label1.setText("<HTML><U>YOUR TEXT HERE</U></HTML>");
                  Label1.setDefaultCursor(Cursor.Hand);
                  }