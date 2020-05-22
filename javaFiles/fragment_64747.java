LinkedHashMap<String,Boolean> includeRatePlans = getCampaign().getDataPackages();
LinkedHashMap<String, Boolean> excludeRatePlans = getCampaign().getSmsPackage();
Iterator<String> iter = excludeRatePlans.keySet().iterator();
while (iter.hasNext()) {
    String excludeRatePlan = iter.next();
    if(excludeRatePlans.get(excludeRatePlan)) {
        for (String includeRatePlan : includeRatePlans.keySet()){
            if (includeRatePlans.get(includeRatePlan))
                if (includeRatePlan.equals(excludeRatePlan)){
                    iter.remove();
            }
        }
    }
}