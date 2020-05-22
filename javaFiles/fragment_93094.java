//After Creating Dialog then we asking if the User that signed in is a manager
if(parseUser.getBoolean("isManager"))
{
    //open manager Class
    startActivity(new Intent(Login.this,ManagerScreen.class));
}
else{
    //open Student Class to fill the survey
    startActivity(new Intent(Login.this,StudentField.class)); 
}