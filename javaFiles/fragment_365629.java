@Override
public Map referenceData(HttpServletRequest request) {
    final List<User> users = this.userService.retrieveAllUsers();
    final Map<String, Object> userMaintenanceModel = new HashMap<String, Object>();
    userMaintenanceModel.put("users", users);  
    return userMaintenanceModel;
}