private BufferedImage getLayer(Layer l) {
    GetMapRequest getMapRequest = wms.createGetMapRequest();
    getMapRequest.addLayer(l);
    getMapRequest.setBBox(l.getEnvelope(DefaultGeographicCRS.WGS84));
    getMapRequest.setDimensions(200, 400);
    getMapRequest.setFormat("image/png");
    getMapRequest.setSRS("CRS:84");
    System.out.println(getMapRequest.getFinalURL());
    try {
        GetMapResponse response = wms.issueRequest(getMapRequest);
        BufferedImage image = ImageIO.read(response.getInputStream());
        return image;
    } catch (ServiceException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return null;
    }

}