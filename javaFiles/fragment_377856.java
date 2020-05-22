try {
    completed = func.addNewOperator(userId, name, ini, cpr, password, role);
}catch (SQLException e) {
    Error = "There was a problem with database access";     
} catch (IOException e) {
    Error = "Error found with connection";
} catch (RuntimeException e) {
    Error = "Error found with entered values";
} catch (Exception e) {
    Error = "Serious error found!";
}

if(Error != null){
    response.sendRedirect("SystemError.jsp?Error_resultat=" + Error);
}