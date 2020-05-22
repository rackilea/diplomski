// paint two blue rectangles on a canvas.
final Canvas canvas = new Canvas(250,250);
GraphicsContext gc = canvas.getGraphicsContext2D();

gc.setFill(Color.BLUE);
gc.fillRect(75,75,100,100);
gc.fillRect(25,25,30,30);