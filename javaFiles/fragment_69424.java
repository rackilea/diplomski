for(int i = 0;i < 4;i++){
     g2d.setColor(Color.red);
     rec = new Rectangle2D.Double(20,x,100,5);
     g2d.draw(rec);

     recList.add(rec);

     x += 50;
}