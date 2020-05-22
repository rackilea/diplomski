enum Difficulty {
    EASY(1, 10, 5000),
    MEDIUM(2, 15, 4000),
    HARD(4, 20, 3500);

    private final int enemyWaves;
    private final int enemiesInWave;
    private final long enemyWaveIntervalMilis;

    Difficulty(int enemyWaves, int enemiesInWave, long enemyWaveIntervalMilis ){
        this.enemyWaves = enemyWaves;
        this.enemiesInWave = enemiesInWave;
        this.enemyWaveIntervalMilis = enemyWaveIntervalMilis;
    }

    public int getEnemyWaves() {

        return enemyWaves;
    }
    public int getEnemiesInWave() {

        return enemiesInWave;
    }
    public long getEnemyWaveIntervalMilis() {

        return enemyWaveIntervalMilis;
    }

}