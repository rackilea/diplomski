HttpSession session = request.getSession();
String usuario = (String)session.getAttribute("usuario");
if (usuario == null) {
    response.sendRedirect("Index.html");
    return;
}
AtomicInteger sessionCount = (AtomicInteger)session.getAttribute("count");
int count = sessionCount.incrementAndGet(); // count = ++sessionCount