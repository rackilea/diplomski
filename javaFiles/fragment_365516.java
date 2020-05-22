protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String filename = URLDecoder.decode(request.getPathInfo(), "UTF-8");
    File file = new File("/path/to/all/movies", filename);

    response.setHeader("Content-Type", "video/quicktime");
    response.setHeader("Content-Length", file.length());
    response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");

    BufferedInputStream input = null;
    BufferedOutputStream output = null;

    try {
        input = new BufferedInputStream(new FileInputStream(file));
        output = new BufferedOutputStream(response.getOutputStream());

        byte[] buffer = new byte[8192];
        for (int length = 0; (length = input.read(buffer)) > 0;) {
            output.write(buffer, 0, length);
        }
    } finally {
        if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
        if (input != null) try { input.close(); } catch (IOException logOrIgnore) {}
    }
}