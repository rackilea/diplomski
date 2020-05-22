public static double distance (Color c1, Color c2){
   double deltaRed=Math.pow((c1.getRed()-c2.getRed())/255.0,2.0);
   double deltaBlue=Math.pow((c1.getBlue()-c2.getBlue())/255.0,2.0);
   double deltaGreen=Math.pow((c1.getGreen()-c2.getGreen())/255.0,2.0);
   double total=Math.sqrt((deltaRed+deltaBlue+deltaGreen)/3.0);
   return total;
 }

 Color color  = nameCell.getCellFormat().getFont().getColor();
 if(distance(color,Color.BLACK) < 0.02)
     options = "0";
 else
     options = "1";