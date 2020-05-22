void drawList(Graphics gg, List points){
   MyPointClass prev p = null;
   for(MyPointClass p : points){
       if(prevp != null){
           gg.drawLine(prevp.x, prevp.y, p.x, p.y);
       }
       prev = p;
    }
}