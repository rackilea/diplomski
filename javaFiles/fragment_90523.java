class MyComponent extends JPanel
 {
     private Color shapeColor = Color.RED;

     public void setShapeColor(Color color)
     {
       this.shapeColor = color; 
     }

    @Override
   public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(shapeColor);
    g.drawString("this is text one", 10, 10);
        //here I draw some shapes based on the 
        //vector size and integers
       }
   }
 }