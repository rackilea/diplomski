void draw() {
   background(0);

   Enemy[] enemyPlayer = new Enemy[60];
   for (int i = 0; i < 5; i += 1) {
       for (int j = 0; j < 11; j += 1) {
           enemyPlayer[j *i] = new Enemy("EnemyPlayerSpaceInvaders.png", 50 + j * 100, 5 + 75 * i, 6);
       }
   }

   // [...]
}