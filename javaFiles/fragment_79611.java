Bitmap bitmap = ... // Load your bitmap here
Canvas canvas = new Canvas(bitmap);
Paint paint = new Paint(); 
paint.setColor(Color.BLACK); 
paint.setTextSize(10); 
canvas.drawText("Some Text here", x, y, paint);