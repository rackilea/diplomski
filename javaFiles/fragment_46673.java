class Player {  
    int x, y;
    int dx = 0, dy = 0;
    float speedX = 5;
    float speedY = 5;
    int size;

    Player(int newX, int newY, int newSize) {
        x = newX;
        y = newY;
        size = newSize;
    }

    void run() {
        display();
        movePlayer();
    }

    void movePlayer() {
        x += dx * speedX;
        y += dy * speedY;
    }

    void display() {
        ellipse(x, y, size, size);
    }

    void pressed(boolean left, boolean right, boolean up, boolean down) {
        if (left)  dx = -1;
        if (right) dx =  1;
        if (up)    dy = -1;
        if (down)  dy =  1;
    }

    void released(boolean left, boolean right, boolean up, boolean down) { 
        if (left)  dx = 0;
        if (right) dx = 0;
        if (up)    dy = 0;
        if (down)  dy = 0;
    }
}