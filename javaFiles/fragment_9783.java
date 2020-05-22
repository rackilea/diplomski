private boolean userExists(UsersDatabase user)
{
String name = user.getUsername();
int userCount = dbHandler.getAllUsers().size();
for (int i = 0; i < userCount; i++)
{
    if (name.compareToIgnoreCase(dbHandler.getAllUsers().get(i).getUsername()) ==0)
        return true;
}
return false;
}