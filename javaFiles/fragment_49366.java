@RequestMapping(
        value = "url", method = RequestMethod.POST
)
public void uploadFile(
        @RequestParam("file") MultipartFile file
) throws IOException {

 InputStream input = upfile.getInputStream();
 Path path = Paths.get(path);//check path
 OutputStream output = Files.newOutputStream(path);
 IOUtils.copy(in, out); //org.apache.commons.io.IOUtils or you can create IOUtils.copy

}