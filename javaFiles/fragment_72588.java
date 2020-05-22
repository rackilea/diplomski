USER_DETAILS user_details = (USER_DETAILES) session.get(USER_DETAILS.class,yourUserId);
user_details.setUser_Name(NewUserName);
user_details.setOrganization_Id(newOrganizationId);
// some other fields update goes here
session.update(user_details);
tx.commit();