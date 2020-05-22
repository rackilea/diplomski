int dx = mouseX - objX, distX = Math.abs(dX), dirX = Math.signum(dX);
int dy = mouseY - objY, distY = Math.abs(dY), dirY = Math.signum(dY);

// Move diagonal
if(distX == distY))
    obj.move(dirX * SQUARE_SIZE, dirY * SQUARE_SIZE);

// Move horizontal
else if(distX > distY)
    obj.move(dirX * SQUARE_SIZE, 0);

// Move vertical
else
    obj.move(0, dirY * SQUARE_SIZE);