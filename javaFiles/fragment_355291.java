// Lets assume student id comes from the client as a request parameter:
String studentId = request.getParameter("stdID");

// Check / validate it
if (studentId == null || studentId.isEmpty() || !existsInDb(studentId)) {
    // Student id is invalid, send back error message
    // or redirect to some error page or login page
}
else {
    // Student id is valid, safe to store it in the session:
    request.getSession().setAttribute("stdID", studentId);
}