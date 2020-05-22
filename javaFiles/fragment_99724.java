public class SecondServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imageParam1 = request.getParameter("imageParam1");

        BufferedImage bi = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);

        // Try replacing with:
        //GetBI fetchBI = new GetBI();
        //BufferedImage bi = fetchBI.get_bi(req.getParameter("imageParam1"));

        Graphics2D g = bi.createGraphics();
        g.setColor(new Color(255, 255, 255));
        g.drawString(imageParam1, 0, 150);
        g.dispose();

        response.setContentType("image/gif");
        ImageIO.write(bi, "gif", response.getOutputStream());
    }
}