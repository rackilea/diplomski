InputStream is = entity.getContent();
try {
    return IOUtils.toByteArray(is);
}finally{
    is.close();
}