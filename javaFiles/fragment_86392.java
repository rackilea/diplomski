if (input.isMousePressed(input.MOUSE_LEFT_BUTTON)) {
        int destX = input.getMouseX() - 30;
        int destY = input.getMouseY() - 50;
        if (!isLocked(destX, destY)) {
                   this.planeX = destX;
                   this.planeY = destY;     
        }
}