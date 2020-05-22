protected void onDraw(Canvas canvas)
{                           
   for (Path p : paths)
   {  
      // Assuming your HashMap variable is pathColor
      m_Paint.setColor(pathColor.get(p));

      canvas.drawPath(p, m_Paint);
   }
}