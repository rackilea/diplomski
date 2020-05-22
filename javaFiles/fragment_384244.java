@Bean
public TilesConfigurer tilesConfigurer() {
    TilesConfigurer tilesConfigurer = new TilesConfigurer();
    tilesConfigurer.setDefinitions("/WEB-INF/views/tiles/tiles.xml");
    tilesConfigurer.setCheckRefresh(true);
    tilesConfigurer.setTilesInitializer(new pringCompleteAutoloadTilesInitializer());
    return tilesConfigurer;
}