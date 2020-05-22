@RequestMapping(value = "/large.csv", method = GET, produces = "text/csv")
@ResponseStatus(value = HttpStatus.OK)
public void streamLargeCSV(OutputStream output) {
    InputStream is = new FileInputStream(csvFile);
    int read=0;
    byte[] bytes = new byte[1024 * 4];  //size per read

    while((read = is.read(bytes))!= -1){
        output.write(bytes, 0, read);
        output.flush();  //may change flush rate to more rows/flush
    }
    output.close()
}