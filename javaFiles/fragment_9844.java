double random = Math.random();     

 if (random > 0 && random <=.3333333)  {
     // Generate a circle with a random size and position
     int diameter = generateRandomInt(MIN_SIZE, MAX_SIZE);
     int x = generateRandomInt(0, WINDOW_SIZE - diameter);
     int y = generateRandomInt(0, WINDOW_SIZE - diameter);
     shapes[i] = new Circle(x, y, color, diameter);
 } else if (random >.3333333 && random < 0.666666) {
     // Generate a rectangle with a random size and
     // position
     int width = generateRandomInt(MIN_SIZE, MAX_SIZE);
     int height = generateRandomInt(MIN_SIZE, MAX_SIZE);
     int x = generateRandomInt(0, WINDOW_SIZE - width);
     int y = generateRandomInt(0, WINDOW_SIZE - height);
     shapes[i] = new Rectangle(x, y, color, width, height);

 } else {
     int leng = generateRandomInt(MIN_SIZE, MAX_SIZE);
     int x = generateRandomInt(0, WINDOW_SIZE - leng);
     int y = generateRandomInt(0, WINDOW_SIZE - leng);
     shapes[i] = new Triangle(x, y, color, leng);                     
 }