gc.beginPath();
gc.arc(posX, posY, RADIUSHALF, RADIUSHALF, 45, 90);

// next arc in opposite direction
gc.arc(posX, posY + BRICK_HEIGHT, RADIUSHALF, RADIUSHALF, 90 + newAngleLowerArc, -2 * newAngleLowerArc);
gc.closePath();

gc.fill();