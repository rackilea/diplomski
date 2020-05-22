while(result_set.next()) {
    String userID = result_set.getString("userID");
    String privilege = result_set.getString("privilege");
    if (previousId == null) { // first time
        User user = new User();
        PrivList.add(privilege);
        previousId=userID;
    } else if (previousId.equals(userID) {
        PrivList.add(privilege);
    } else { 
        // nex user
        user.setUserPrivilege(PrivList);
        allUserList.add(user);
        PrivList = new ArrayList<>();  // <--
        PrivList.add(privilege);       // <--
        previousId=null;
    }
}