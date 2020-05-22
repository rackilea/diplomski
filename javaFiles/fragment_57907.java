private static void bar() {
    String jsonStr = "{\"status\":\"SUCCESS\",\"uData\":[{\"User_ID\":\"4\",\"login_status\":\"1\",\"lastseen\":\"0000-00-00 00:00:00\"},{\"User_ID\":\"1\",\"login_status\":\"0\",\"lastseen\":\"0000-00-00 00:00:00\"},{\"User_ID\":\"12\",\"login_status\":\"1\",\"lastseen\":\"0000-00-00 00:00:00\"},{\"User_ID\":\"33\",\"login_status\":\"0\",\"lastseen\":\"0000-00-00 00:00:00\"}]}";
    Gson gson = new Gson();
    UserFoo userFoo = gson.fromJson(jsonStr, UserFoo.class);
    Map<String, UserFoo.User> map = new HashMap<>();
    for (UserFoo.User u : userFoo.getUData()) {
        map.put(u.getUser_ID(), u);
    }
    System.out.println("userId: 12, loginState: " + map.get("12").getLogin_status());
}

public static class UserFoo {

    /**
     * status : SUCCESS
     * uData : [{"User_ID":"4","login_status":"1","lastseen":"0000-00-00 00:00:00"},{"User_ID":"1","login_status":"0","lastseen":"0000-00-00 00:00:00"},{"User_ID":"12","login_status":"1","lastseen":"0000-00-00 00:00:00"},{"User_ID":"33","login_status":"0","lastseen":"0000-00-00 00:00:00"}]
     */

    private String status;
    private List<User> uData;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getUData() {
        return uData;
    }

    public void setUData(List<User> uData) {
        this.uData = uData;
    }

    public static class User {
        /**
         * User_ID : 4
         * login_status : 1
         * lastseen : 0000-00-00 00:00:00
         */

        private String User_ID;
        private String login_status;
        private String lastseen;

        public String getUser_ID() {
            return User_ID;
        }

        public void setUser_ID(String User_ID) {
            this.User_ID = User_ID;
        }

        public String getLogin_status() {
            return login_status;
        }

        public void setLogin_status(String login_status) {
            this.login_status = login_status;
        }

        public String getLastseen() {
            return lastseen;
        }

        public void setLastseen(String lastseen) {
            this.lastseen = lastseen;
        }
    }
}