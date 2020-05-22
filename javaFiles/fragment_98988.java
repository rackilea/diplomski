void checkCollisions() {
    for(int i = 0; i < Shoot.allBullets.size(); i++){  
        for(int j = 0; j < Enemy.allEnemies.size(); j++){
            if(new Rectangle((int)Shoot.allBullets.get(i).x, (int)Shoot.allBullets.get(i).y, 23, 48).intersects(new Rectangle((int) Enemy.allEnemies.get(j).x, (int) Enemy.allEnemies.get(j).y, 64, 64))) {
                bulletIntersectsEnemy(i, j);
            }
        }
    }
}

void bulletIntersectsEnemy(int bulletIndex, int enemyIndex) {
    Shoot.allBullets.remove(bulletIndex);
    Enemy.allEnemies.remove(enemyIndex);
}