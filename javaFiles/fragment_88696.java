for (int i = 0; i < 10; i++) {
    newPosX += deltaX * 0.1; // 1/10th of the usual update
    newPosY += deltaY * 0.1; // 1/10th of the usual update
    if (checkCollision(newPosX, newPosY))
    {
        posX = newPosX;
        posY = newPosY;
    }
    else
    {
        break; // We hit something, no more mini-updates necessary.
    }
}