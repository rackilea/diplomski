"SELECT slh.assetId,slh.mapHierarchy "
+ "FROM AssetHistory slh "
+" WHERE (slh.assetId, slh.lastUpdated)"
+ " IN 
+ "(SELECT assetId, MAX(lastUpdated) AS MaxDateTime "
+ "FROM AssetHistory "
+ "GROUP BY assetId);