public void onScannedRobot(ScannedRobotEvent e) {
    String name;
    EnemyInfo enemy = (EnemyInfo) enemies.get(name = e.getName());
    // if the enemy is not already on the hashtable, puts it on
    if (enemy == null) {
        enemies.put(name, enemy = new EnemyInfo());
    }
    enemy.bearing = e.getBearing();
    enemy.velocity = e.getVelocity();
    enemy.heading = e.getHeading();
    enemy.energy = e.getEnergy();
    enemy.lastSeen = e.getTime();