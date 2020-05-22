private static boolean checkForNullEntries(Map<String, Table> map) {
    if(map.get("String") != null) {
        if (StringUtil.isNullOrEmpty(map.get("String").getName())) {
            return true;
        } else if (map.get("String").getLastUpdateTime() == null) {
            return true;
        }
        return false;
    }
    if(map.get("Date") != null) {
        if (map.get("Date").getTimeSlot == null) {
            return true;
        } else if (map.get("Date").getDate() == null) {
             return true;
        }
        return false;
    }
    return false;
}