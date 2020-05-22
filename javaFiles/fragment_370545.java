public void drawWall (int width,int height,int wallListSize,int x1,int x2,int y1,int y2){

    wall = new Rect();
    //setting up starting position for next wall
    if (chooseDirection(width)){
        //vertical
        if (y1<y2){
            // up to down stroke

            wall.set(startX,startY,wallThickness+startX,height+startY);
            startY = wall.height();
           // startX=startX+wallThickness;
            Log.i(TAG, "drawWall: up to down stroke");


        }else  {
            //down to up stroke

            wall.set(startX,height-startY,wallThickness+startX,startY);
            startY = startY - wall.height();
           // startX = startX + wallThickness;
            Log.i(TAG, "drawWall: down to up stroke");


           // startX = wall
        }
    }else {
        //horizontal
        if (x1<x2){
            //left to right stroke
            Log.i(TAG, "drawWall: left to right stroke");
            wall.set(startX,startY,width+startX,wallThickness+startY);
            startX = wall.width();
           // startY = startY+wallThickness;
        }else {
            //right to left stroke
            wall.set(width-startX,startY,startX,wallThickness+startY);
            Log.i(TAG, "drawWall: right to left stroke");
            startX = startX-wall.width();
           // startY = startY+wallThickness;
        }
    }
    //adding wall to the pool
    wallList.add(wall);

    //Checking if there is more walls or not
    Log.i(TAG, "drawWall: Rect bottom:"+wall.bottom+" right:"+wall.right+" top:"+wall.top+" left:"+wall.left);
    Log.i(TAG, "drawWall: ---STARTING POSITION FOR NEXT WALL--- startX "+startX+" startY "+startY+" ");
    if (wallIndex < wallListSize){
        wallIndex++;

    }else {
        Log.i(TAG, "drawWall: end of drawing, matching layout to wrap content");
        startDraw = true;
        invalidate();
    }
}