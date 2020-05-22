if(username.equals(c.getUsername()) &&password.equals(c.getPassword())){
    output.println("Welcome, " + username);
}else{
    output.println("Login Failed");
}
output.flush();
output.close();