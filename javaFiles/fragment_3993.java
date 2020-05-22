@POST
    @Path("upload/{id}")
    @Consumes({"application/x-www-form-urlencoded", "multipart/form-data"})

    public void addBlob(@PathParam("id") Integer id, @FormDataParam("file") InputStream uploadedInputStream) throws IOException {
        E24ClientTemp entityToMerge = find(id);
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            entityToMerge.setTestBlob(out.toByteArray());
            super.edit(entityToMerge);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }