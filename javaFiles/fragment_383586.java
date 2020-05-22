package com.example;

public class EhCacheWithStatisticsFactoryBean extends EhCacheFactoryBean {

    private boolean statisticsEnabled;

    @Override
    public void afterPropertiesSet() throws CacheException, IOException {
        super.afterPropertiesSet();
        getObject().setStatisticsEnabled(statisticsEnabled);
    }

    public void setStatisticsEnabled(boolean statisticsEnabled) {
        this.statisticsEnabled = statisticsEnabled;
    }
}