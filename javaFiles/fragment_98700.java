public static void main(String[] args) {
     User user = new User();
     IGenericDao<User> iGenericDao = new HibernateDAO<>();
     user.setUserName("bibekshakya35");
     user.setUserPassword("ros3");
     user.setUserType(UserType.GUEST);
     user.setActive(true);
     UserProfile userProfile = new UserProfile();
     userProfile.setAge(21);
     userProfile.setBasicInfo("kdhsa");
     userProfile.setEmailId("dsadas@gmail.com");
     userProfile.setUserGender(UserGender.Male);
     userProfile.setFullname("bibek shakya");
     userProfile.setMobileNumber("45454545");
     userProfile.setLandLineNumber("445444");
     userProfile.setUserProfilePic("index.jsp");
     user.setUserProfile(userProfile);
     AuditInfo auditInfo = new AuditInfo();
     auditInfo.setCreatedOn(new Date());
     auditInfo.setModifiedOn(new Date());
     auditInfo.setVerifiedOn(new Date());
     user.setAuditInfo(auditInfo);
     iGenericDao.create(user);
   }