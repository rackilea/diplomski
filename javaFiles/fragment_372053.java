@ResponseBody
@RequestMapping(value = "/images/{path}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
@Cacheable("images")
public byte[] image(@PathVariable path) throws IOException {
    InputStream in = servletContext.getResourceAsStream("images/"+path);
    return IOUtils.toByteArray(in);
}