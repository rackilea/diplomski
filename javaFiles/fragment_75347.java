@POST
@Path("something")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_OCTET_STREAM)
public Response post(Model model) throws Exception {
    final InputStream in = new FileInputStream("path-to-file");
    StreamingOutput entity = new StreamingOutput() {
        @Override
        public void write(OutputStream out) {
            IOUtils.copy(in, out);
            out.flush();
        }
    };
    return Response.ok(entity)
            .header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment;filename=somefile.xls")
            .build();
}