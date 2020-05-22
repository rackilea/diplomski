@RequestMapping(value = "/image/{id}/{quality}/{pageNumber}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
public void retrieveImage(@PathVariable Long id, @PathVariable String quality, @PathVariable Integer pageNumber,
        HttpServletResponse response) throws Exception{

    //Open connection
    S3Object s3Object = imageService.getS3Object(quality, pageNumber, id)
    S3ObjectInputStream s3ObjectIS = s3Object.getObjectContent();

    byte[] data = new byte[2048];
    int read = 0;
    OutputStream out = response.getOutputStream();
    while((read = s3ObjectIS.read(data)) > 0) {
        out.write(data, 0, read);
        out.flush();
    }
    out.close();

    //Then close connection to amazon......
}