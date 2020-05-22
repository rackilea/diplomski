Path mCharacterPath=new Path();


public void onDraw(Canvas canvas) {

      canvas.drawBitmap (mCharacter, mPosX, mPosY, mCharacterPaint);
      canvas.drawPath (mCharacterPath, mPathPaint);

}

public void add_point_to_path(int x, int y) {
       mPath.lineTo(x,y);
}