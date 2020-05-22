public  ResponseWrapper create(Principal principle) {    
    try {
        ResponseWrapper wrap = new ResponseWrapper(); 

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

         /**ADD THIS**/
        AssignRoles assignROles = new AssignRoles();
        assignRoles.setPrincipalObject(principal);
        assignRoles.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName())  //send username

        SecurityContextHolder.getContext().getAuthentication().getAuthorities() //It will print assigned roles

        return wrap;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}