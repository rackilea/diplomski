public void download(Integer id, HttpServletResponse response){
    Line line = getById(Line.class, id);
    InputStream is = line.getFile().getBinaryStream;
    IOUtils.copy(is, response.getOutputStream());
    response.flushBuffer();
}