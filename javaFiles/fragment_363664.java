public void init(ServletConfig config) throws ServletException {
    super.init(config);
    ServletContext context = getServletContext();
    InputSource xmlFile = new InputSource(context.getResourceAsStream("/WEB-INF/balle.xml"));
    try {
        xd = new XMLDoc(xmlFile);
    } catch (Exception e) {
        System.out.println("Something wrong happened");
    }
}