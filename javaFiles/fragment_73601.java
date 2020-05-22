public boolean isCatalogActive(CatalogVersion catalogVersion, int itemBusinessUnit) {
    Calendar today = Calendar.getInstance();
    // Check to see if the catalog is still available
    Calendar fromDate = catalogVersion.getEffectiveDate();
    int gracePeriodDays = companyService.getPricingGracePeriodDays(itemBusinessUnit);
    fromDate.add(Calendar.DAY_OF_YEAR, gracePeriodDays * -1);
    if (today.before(fromDate)) {
        return false;
    } else {
        return true;
    }
}