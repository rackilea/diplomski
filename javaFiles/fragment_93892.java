frame(show:true) 
  {
      label "<html>" + (("This is a very long label."*3) + "<BR>")*5
      current.pack()
      Point cp = GraphicsEnvironment.localGraphicsEnvironment.centerPoint
      current.location = new Point((int)(cp.x -current.width/2), (int)(cp.y - current.height/2))
  }