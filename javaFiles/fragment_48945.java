@Override
public void invoke(Request request, Response response) 
        throws IOException, ServletException {
    getNext().invoke(request, response);
    Session session = request.getSessionInternal();        
    HttpSession deltaSession = (HttpSession) session;
    for (Enumeration<String> names = deltaSession.getAttributeNames(); 
            names.hasMoreElements(); ) {
        String name = names.nextElement();
        deltaSession.setAttribute(name, deltaSession.getAttribute(name));
    }
}