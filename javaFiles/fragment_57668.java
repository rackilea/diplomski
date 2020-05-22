@ResponseBody
@RequestMapping("picture/{theString}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
public byte[] testphoto(@PathVariable("theString") String theString) throws IOException 
{
    InputStream in = servletContext.getResourceAsStream("/images/no_image.jpg"); // 
    //Here you may write above code in service class to read file from path "/src/main/resources" as stream and return it to controller class.

    return IOUtils.toByteArray(in);
}