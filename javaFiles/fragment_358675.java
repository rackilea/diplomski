get("/image", (request, response) -> {
    String imageName = request.queryParams("imageName");
    response.raw().setContentType("image/tiff");
    response.raw().setHeader("Content-Disposition","attachment; filename=image.tiff");
    Path path = Paths.get(IMAGE_DESTINATION + "/" + imageName);
    byte[] data = null;
    try {
        data = Files.readAllBytes(path);
    } catch (Exception e) {
        e.printStackTrace();
    }
    OutputStream out = response.raw().getOutputStream();
    out.write(data);
    out.flush();
    out.close();
    return response.raw();
});