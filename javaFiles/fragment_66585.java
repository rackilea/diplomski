//removing the enemy
while (enemyIterator.hasNext()) {

    Sprite nextEnemy = enemyIterator.next();
    if(enemySpr.getY() + enemySpr.getHeight() >= treeObj.treeSpr.getY()) {
        enemyIterator.remove();
        Pools.free(nextEnemy);
    }
}