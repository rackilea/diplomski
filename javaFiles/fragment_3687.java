@RequestMapping(value = "/file/{dummyparam}.pdf", method = RequestMethod.GET, produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
public void getFile(@PathVariable("dummyparam") String dummyparam, HttpServletResponse response) {


    InputStream is = new FileInputStream(resultFile);

    response.setHeader("Content-Disposition", "attachment; filename=\"dummyname " + dummyparam + ".pdf\"");


    int read=0;
    byte[] bytes = new byte[BYTES_DOWNLOAD];
    OutputStream os = response.getOutputStream();

    while((read = is.read(bytes))!= -1){
        os.write(bytes, 0, read);
    }
    os.flush();
    os.close(); 
}