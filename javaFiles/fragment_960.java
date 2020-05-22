String login = (String)session.getAttribute("login").trim();
String loginDemandeur = d3.getLogin_demandeur().trim(); // Assuming getLogin_demandeur has return type as String. 
if(!login.equalsIgnoreCase(loginDemandeur)){
  //do something
}else{
  //do something else
}