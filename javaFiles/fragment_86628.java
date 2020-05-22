@RequestMapping(value = "/search", method = RequestMethod.GET)
@ResponseBody
public List<UserInfo> fetchTableData(@RequestParam("tableId") String tableId) {
    try {
        List<UserInfo> userList = new ArrayList<>();
        System.out.println(" table id id " + tableId);
        if (tableId != null) {
            userList = userInfoDao.findById(tableId);
        }
        return userList;
    } catch (Exception e) {
        // log it, don't print the stacktrace...
        return Collections.emptyList()
    }
}