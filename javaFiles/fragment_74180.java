void executeUpdateSweep(List<CoordinateCacheItem> cacheItems)
{
    for(CoordinateCacheItem item : cacheItems)
    {
        if(shouldRefreshCache(item))
        {
            //call api with lat = item.y , lng = item.x
        }
    }
}

boolean shouldRefreshCache(item)
{
    long ageWeight = calculateAgeWeight(item);//how long since last update?
    long basePopulationWeight = item.getBasePopulationWeight();//how many people (users and non-users) live here?
    long usageWeight = calculateUsageWeight(item);//how much is this item requested?

    return ageWeight + basePopulationWeight + usageWeight > someArbitraryThreshold;
}