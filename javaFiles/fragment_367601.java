class MyRectangle extends Rectangle{
   public MyRectangle(Rectangle r){
      super(r); //use the copy constructor in the Rectangle class
   }

   //then you could add your own methods
   public int getArea(){
      return getWidth() * getHeight();
   }
}