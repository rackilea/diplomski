listOfApplications = managerHibernate.loadAllData(Application.class);
//loading user data and close the session associated with it
listOfUsers = managerHibernate.loadAllData(User.class);
User user = null;
Application app = null;

for(Application index: listOfApplications)
{
  if(index.getApplicationName().equals(applicationName))
      {
          okApp = 1;
          app = index;
      }
}

for(User index: listOfUsers)
{
  if(index.getUserUserName().equals(userUserName))
      {
          okUser = 1;
          user = index;
      }
}

if(okUser == 0  || okApp == 0)
  return false;
else
{   
  // when you run this line the hibernate framework will try to retrieve the application data.Since you have the closed session lazy load exception occurs 
  user.getListOfApplications().add(app);
  return true;
}