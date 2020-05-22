try {
    Metrics metrics = new Metrics(this);
    if (!metrics.isOptOut()) {
        final Graph blocksMinedGraph = metrics.createGraph("Extra items from blocks (Since v2.3)");
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, new Runnable() {
            public void run() {
                getLogger().info("Graph data sent");
                blocksMinedGraph.addPlotter(new Metrics.Plotter("Coal Ore") {
                    @Override
                    public int getValue() {
                        return coalMined;
                    }
                });
                blocksMinedGraph.addPlotter(new Metrics.Plotter("Iron Ore") {
                    @Override
                    public int getValue() {
                        return ironMined;
                    }
                });
            }
        }, DELAY, INCREMENT);
        getLogger().info("Metrics started");
        metrics.start();
    }
} catch (IOException e) {
    getLogger().info(ANSI_RED + "Metrics have been unable to load for: DenseOres" + ANSI_RESET);
}