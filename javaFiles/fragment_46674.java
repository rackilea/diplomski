Player player1;
Player player2;

void setup() {
    // [...]
}

void draw() {
    // [...]
}

void keyPressed() {
    player1.pressed((key == 'a' || key == 'A'), (key == 'd' || key == 'D'),
                    (key == 'w' || key == 'W'), (key == 's' || key == 'S'));

    player2.pressed(keyCode == LEFT, keyCode == RIGHT, keyCode == UP, keyCode == DOWN);
}

void keyReleased() {
    player1.released((key == 'a' || key == 'A'), (key == 'd' || key == 'D'),
                     (key == 'w' || key == 'W'), (key == 's' || key == 'S'));

    player2.released(keyCode == LEFT, keyCode == RIGHT, keyCode == UP, keyCode == DOWN);
}