<%
    String filePath = photoPath + nom.toLowerCase().replace(' ', '_')
        +"_"+prenom.toLowerCase().replace(' ', '_') + ".jpg";
    Path path = Paths.get(request.getServletContext().getRealPath(filePath));
    if (Files.exists(path)) { 
 %>