public Player(int direction, boolean move, Context context){  //constructior with Context
    this.direction = direction;
    this.move = move;

    Drawable myDrawable = context.getResources().getDrawable(R.drawable.down_standing);  // This is right
    Bitmap downStanding = ((BitmapDrawable) myDrawable).getBitmap();
}