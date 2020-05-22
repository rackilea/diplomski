public void clear()
 {
   textvalue="";// set textvalue to null

  mBitmapPaint = new Paint(Paint.DITHER_FLAG);
  mBitmap = Bitmap.createBitmap(320,480,Bitmap.Config.ARGB_8888);
  mCanvas = new Canvas(mBitmap);    
  path = new Path(); 
   //reset drawing tools. reset other drawing tools. (linepaint, cirlce paint..)        
  mypaint = new Paint();
  mypaint.setAntiAlias(true);
  mypaint.setDither(true);
  mypaint.setColor(0xFFFF0000);
  mypaint.setStyle(Paint.Style.STROKE);
  mypaint.setStrokeJoin(Paint.Join.ROUND);
  mypaint.setStrokeCap(Paint.Cap.ROUND);
  paint = new Paint();
  paint.setAntiAlias(true);
  paint.setDither(true);
  paint.setColor(0xFFFF0000);
  paint.setStyle(Paint.Style.STROKE);
  paint.setStrokeJoin(Paint.Join.ROUND);
  paint.setStrokeCap(Paint.Cap.ROUND);
  eraserList.clear();
  lineList.clear();
  freehandList.clear();
  circleList.clear();
  ovalList.clear();
  rectangleList.clear();
  invalidate(); //refresh your view. try this
  }