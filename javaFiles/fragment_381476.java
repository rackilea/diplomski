@Cacheable(cacheNames = "detailedData", key = "#id", condition ="#currentPackage.sellingPrice > -1")
public Map<String, Object> getDetailedTestData(int id,PackageEntity currentPackage) {
  /**
    some code
  */
}