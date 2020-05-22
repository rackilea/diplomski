final int height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics());
final int width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics());

Graphics g = game.getGraphics();
g.clearScreen(Color.BLACK);   
g.drawRect(0, 0, width, height, Color.GREEN);