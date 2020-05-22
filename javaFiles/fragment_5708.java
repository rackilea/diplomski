public void draw(Canvas canvas) {

 Rect canvasBounds = canvas.getClipBounds();         //get the current clip(Canvas drawing area)
 this.image.setBounds(canvasBounds);      //same bounds as canvas, so image is the same size. We clip next

 Rect imageBounds=new Rect(0,0,this.width,this.height); //You should move this line to constructor. You know, performance and all.                                                                

 canvas.save();                 //save the current clip. You can't use canvasBounds to restore it later, there is no setClipBounds()
 canvas.clipRect(imageBounds); //clip the canvas so you draw only the width and height u want
 this.image.draw(canvas);
 canvas.restore();       //restore the Canvas clip. 

 //do other drawings with full size canvas