@Bean
    public ThymeleafTilesConfigurer thymeleafTilesConfigurer(){
        final ThymeleafTilesConfigurer configurer = new ThymeleafTilesConfigurer();
        configurer.setDefinitions(new String[] { "WEB-INF/tiles/tiles-defs.xml" });
        configurer.setCheckRefresh(true);
         return configurer;
    }