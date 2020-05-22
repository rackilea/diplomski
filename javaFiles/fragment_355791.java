@RequestMapping("/getImage/{id}")
public void getImage(HttpServletResponse response,@PathVariable("id") final String id) throws IOException {
    response.setContentType("image/jpeg");
    byte[] imageBytes = dao.getImage(id);
    response.getOutputStream().write(imageBytes);
    response.getOutputStream().flush();
}