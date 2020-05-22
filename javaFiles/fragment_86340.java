public String accept(HttpServletRequest request, HttpServletResponse response, Principal principal,Model model) { //Get HttpServletResponse instance
    if(checkMember(currentuser_id, token, principal,model)) {
        return "somepage"; //Configure View Resolver for JSP
    } else {
        try {       
            PrintWriter out = response.getWriter();
            out.println("You are already a Member of this Project");
            out.close();
        } catch (IOException ex) { 
            //Use Logger
        }
        return null;
    }
}