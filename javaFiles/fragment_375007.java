@Override
protected void service(HttpServletRequest hsr, HttpServletResponse hsr1) throws ServletException, IOException {
    final int TO_SEND = 1; //number of time each image should be downloaded before purge (-1 = no purge)
    HashMap<String, CachedImage> images = new HashMap<String, CachedImage>();
    ...
    // calculates listaNews
    // loads all the images from database and store them in session
    for(...) { // loops for the images key id , InputStream is
        images.put(id, new CachedImage(TO_SEND, is));
    }
    HttpSession session = hsr.getSession();
    session.setAttribute("cachedImages", images);
}