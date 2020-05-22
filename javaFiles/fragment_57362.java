Random rand = new Random();
float x1 = Math.min(corner1.x, corner2.x);
float x2 = Math.max(corner1.x, corner2.x);
float deltaX = x2 - x1;
float offsetX = rand.nextFloat() * deltaX;
float randomX = x1 + offsetX;