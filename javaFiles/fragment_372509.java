String[] allRoles = {"1","2","3"};
HttpServletRequest request = ... (or from method argument)
List userRoles = new ArrayList(allRoles.length);
for(String role : allRoles) {
 if(request.isUserInRole(role)) { 
  userRoles.add(role);
 }
}

// I forgot the exact syntax for list.toArray so this is prob wrong here
return userRoles.toArray(String[].class);