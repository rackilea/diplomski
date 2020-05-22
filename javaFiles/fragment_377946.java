public void save(ActionRequest request, ActionResponse response) throws SystemException {

    String name = request.getParameter("name");
    String password = request.getParameter("password");
    System.out.println(name + " - " + password);

    try {
        UserDetails ud = UserDetailsLocalServiceUtil.createUserDetails(name, password);
        // Do whatever you want after creating new details
    }
    catch(Exception ex) {
         ex.printStackTrace();
    }
}