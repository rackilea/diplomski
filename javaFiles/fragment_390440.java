@GET
@Path("/{key}/meta")
@Produces(MediaType.APPLICATION_JSON)
public Response redirect(@PathParam("key") String key) throws IOException {
BlobKey blobKey = new BlobKey(key);
BlobInfo info = blobInfoFactory.loadBlobInfo(blobKey);

String name = info.getFilename();
long size = info.getSize();
String url = "/rest/file/" + key; 
FileMeta meta = new FileMeta(name, size, url);

List<FileMeta> meta = Lists.newArrayList(meta);
EntityClass entity= new EntityClass();
entity.setFiles(meta);
return Response.ok(entity).build();
}