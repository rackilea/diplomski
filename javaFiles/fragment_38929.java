int i = 0;
while (!shell.isDisposed())
{
  if (!display.readAndDispatch())
  {
     display.sleep();
     i++;
   //  System.out.println(i);
     if(i==100)
     {
         GC source = new GC (shell);  
         Image image = new Image(display, browser.getClientArea()); 
         source.copyArea(image, 0, 0);
         ImageLoader io = new ImageLoader ();
         io.data = new ImageData[] { image.getImageData() };
         File f = new File (currentDir+"/workpng.png");
         io.save (f.getAbsolutePath(), SWT.IMAGE_PNG); 
     }
  }
}