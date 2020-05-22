String message = "";
if (rs.next()) {
    if (rs.getString(2).equals(pwd)) {
         message =  "welcome " + user;
    } else {
         message = "Invalid password try again";
    }
}else{
    message = "Invalid user try again";
}
out.println(message);