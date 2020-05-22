@RequestMapping(value = "/function/{functionId}/image.gif", produces = "image/gif")
public void getImage(@PathVariable(value = "functionId") String functionId, HttpServletResponse response) throws IOException {

    BufferedImage firstImage = ImageIO.read(new File("/bla.jpg"));
    response.setContentType("image/gif"); // this should happen automatically

    ImageIO.write(firstImage, "gif", response.getOutputStream());
    response.getOutputStream().close();
}