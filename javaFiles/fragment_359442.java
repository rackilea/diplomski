glMatrixMode(GL_PROJECTION);
glLoadIdentity();
xOff = player.x - GAME.WIDTH / 2;
yOff = player.y - GAME.HEIGHT / 2;
glOrtho(xOff, xOff + GAME_WIDTH, yOff + GAME_HEIGHT, yOff, 1, -1);
glMatrixMode(GL_MODELVIEW);