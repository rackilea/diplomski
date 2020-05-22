for(int i=0;i<enemies.size();i++){
    Enemy enemy = enemies.get(i);
    for(int j=0;j<upgrades.size();j++){
        Upgrade upgrade = upgrades.get(j);
        if(main.distance(enemy.getX(),upgrade.getX(),enemy.getY(),upgrade.getY())<15){
            //enemy is close to upgrade.
        }
    }
}