int lastKey = 0;
void keyPressed() {
    if (lastKey != key) {
        lastKey = key; 
        ch.move();
    }
}

void keyReleased() {
    lastKey = 0;
}