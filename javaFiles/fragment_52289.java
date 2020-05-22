Class ShapeDrawer{
     private Shape shape;  

     public void setShape(Shape shape){
         this.shape = shape;
     }

     public void paint(){
         shape.draw(); 
     } 

 }