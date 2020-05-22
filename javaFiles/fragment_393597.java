int loginAttempt = (Integer)session.getAttribute("loginCount");

if (loginAttempt > 3 ){
     // Error message/page redirection 
}else{
     session.setAttribute("loginCount",loginAttempt++);
}