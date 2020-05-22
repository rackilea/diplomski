public class MyImageView extends ImageView {
        ...
        @Override
        public void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Point[] point = ... //create three points here for the triangle
            Paint paint = ... // create your desired color
            drawTriangle(canvas, point, paint);
    }