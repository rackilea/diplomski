public JInternalFrame getFrontFrame(){       
   InternalFrame[] array = desktop.getAllFrames();
  JInternalFrame f=(JInternalFrame)array[0];

 return f;

 }