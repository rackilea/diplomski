@ApiOperation(value = "export",
        notes = "Export Cache details for a given criteria")
@ApiImplicitParams({

})
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
@RequestMapping(method = RequestMethod.GET, value = "/export")
public ResponseEntity export( HttpServletRequest request )
{
    CacheDataManager cacheResultHandler = new CacheDataManager();
    InputStreamResource inputStreamResource = null;
    InputStream inputStream = null;
    byte[] byteArray = new byte[0];
    HttpHeaders httpHeaders = new HttpHeaders();

    try
    {
        inputStreamResource = cacheResultHandler.exportCacheResults( request );
        httpHeaders.set( HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "test.csv" );

        //convert inputStream to bytes
        inputStream = inputStreamResource.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        byteArray = buffer.toByteArray();

        httpHeaders.setContentLength(byteArray.length);
    }
    catch ( IOException e )
    {
        e.printStackTrace();
    }

    return new ResponseEntity( byteArray, httpHeaders, HttpStatus.OK );

}