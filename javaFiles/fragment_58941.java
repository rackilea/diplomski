void rotate90(){
  if(image!=null){
            int w = image.getWidth(null); //the Width of the original image
    int h = image.getHeight(null);//the Height of the original image            
    if(w>h){
            BufferedImage dimg = new BufferedImage(w, w,  BufferedImage.TYPE_3BYTE_BGR );
            Graphics2D g = dimg.createGraphics();
            g.translate(-(w-h), 0);
            g.rotate(Math.toRadians(90), w/2, w/2);
            g.drawImage(image, 0, 0,null);
            BufferedImage bimg = new BufferedImage(h, w,  BufferedImage.TYPE_3BYTE_BGR );       
            Graphics2D g2 = (Graphics2D)bimg.getGraphics();
            g2.drawImage(dimg,0,0,h,w,0,0,h,w,null);
            dimg.flush();
            dimg=null;
            image = createImage(bimg.getSource());
            bimg.flush();
            bimg= null;
    }
    else{
            BufferedImage dimg = new BufferedImage(h, h,  BufferedImage.TYPE_3BYTE_BGR );
            Graphics2D g = dimg.createGraphics();
            g.translate(-(w-h), 0);
            g.rotate(Math.toRadians(90), w/2, w/2);
            g.drawImage(image, 0, 0,null);
            BufferedImage bimg = new BufferedImage(h, w,  BufferedImage.TYPE_3BYTE_BGR );       
            Graphics2D g2 = (Graphics2D)bimg.getGraphics();
            g2.drawImage(dimg,0,0,h,w,0,0,h,w,null);
            dimg.flush();
            dimg=null;
            image = createImage(bimg.getSource());
            bimg.flush();
            bimg= null;
    }
  }
}


void rotateClockWise(){
 if(image!=null){
 rotate90();
 setPanelsize();
 revalidate();       
 repaint();
   }