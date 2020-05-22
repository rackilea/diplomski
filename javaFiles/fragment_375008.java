@Override
protected void service(HttpServletRequest hsr, HttpServletResponse hsr1) throws ServletException, IOException {
    String id = hsr.getParameter("idI");
    HttpSession session = hsr.getSession();
    Map<String,CachedImage> images = (Map<String,CachedImage>) session.getAttribute("cachedImages");
    if (images != null) { // Ok map is in session
        CachedImage cached = images.get(id);
        if (cached != null) { // ok image is in cache
            if (cached.toSend > 0) { // if relevant, evict image from session cache
                if (--cached.toSend == 0) {
                    images.remove(id);
                }
            }
        }
        //send cached image : cached.data
    }
    // load image from database and send it
}