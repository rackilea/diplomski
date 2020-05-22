try {
  GetMapResponse response = wms.issueRequest(getMapRequest);
  if (response.getContentType().equalsIgnoreCase(format)) {
    BufferedImage image = ImageIO.read(response.getInputStream());
    return image;
  } else {
    StringWriter writer = new StringWriter();
    IOUtils.copy(response.getInputStream(), writer);
    String error = writer.toString();
    System.out.println(error);
    return null;
  }
} catch (ServiceException | IOException e) {
  // TODO Auto-generated catch block
  e.printStackTrace();
  return null;
}