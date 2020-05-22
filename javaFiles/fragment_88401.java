@RequestMapping(path = "{username}", method = RequestMethod.GET)
public Map readAllData(@PathVariable String username) {  
    Map<String, Object> items = new HashMap();
    items.put("dailyData", allData.readDailyData(username));
    items.put("monthlyData", allData.readMonthlyData(username));
    return items;
}