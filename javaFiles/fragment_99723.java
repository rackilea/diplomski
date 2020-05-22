protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
throws ServletException, IOException {
    // Create the BufferedImage, using any parameters and
    // possibly the exact request URI:
    String requestURI = req.getRequestURI();
    String imageParam1 = req.getParameter("imageParam1");
    BufferedImage bi = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
    GetBI fetchBI = new GetBI();
    bi = fetchBI.get_bi(req.getParameter(imageParam1));

    resp.setContentType("image/gif");//256 colors
    ImageIO.write(bi,"gif",resp.getOutputStream());
}