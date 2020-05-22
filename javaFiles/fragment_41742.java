response = Response.status(Response.Status.OK).type("application/zip").entity(new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException {
                   output.write(byteArrayOutputStream.toByteArray());
                   output.flush();
               }
            });
        response.header("content-disposition", "attachment; filename=\"testZip.zip\"");