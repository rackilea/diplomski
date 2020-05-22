<%!
    private final Logger logger = new Logger(this.getClass());
    private UserService userService = null;
    public void jspInit() {
        userService = new UserService();
    }
    private String getUserStatus(String userID) {
        return userServce.getUserStatus(userID);
    }
%>

<%
    String userID = request.getParameter("userid");
    String userStatus = getUserStatus(userID);
%>