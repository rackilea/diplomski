//PImage enemyPlayer; <--- DELETE

// global array of enemies
Enemy[] enemyPlayer = new Enemy[60];

// [...]

void setup() {
    size(1400, 800);

    mainPlayer = loadImage("MainPlayerSpaceInvaders.png");

    // create enemies
    for (int i = 0; i < 6; i += 1) {
        for (int j = 0; j < 10; j += 1) {
            enemyPlayer[i*10 + j] = new Enemy("rocket64.png", 50 + j * 100, 5 + 75 * i, 6);
        }
    }
}

void draw() {
    background(0);

    // move enemies
    for(int i = 0; i < enemyPlayer.length; ++i ) { 
        if(enemyPlayer[i].alive){
            enemyPlayer[i].Draw();
        }
        enemyPlayer[i].moveAndDraw(6);
    }
}