public StreamingResponseBody stream(HttpServletRequest req)
        throws FileNotFoundException {
    File file = new File(req.getRealPath("/")+"js/loginPage/usermanual.pdf");
    InputStream is = new FileInputStream(file);
    return (os) -> {
        IOUtils.copy(is, os);
    };
}