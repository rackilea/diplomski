class MyRectangle{
   private Rectangle r;

   public MyRectangle(Rectangle r){
      this.r = r;
   }

   public int getArea(){
      return r.getWidth()*r.getHeight();
   }
}