@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_OCTET_STREAM)
@POST
@Path("/getCredentials")
public Response getCredentials(HashMap<String, String> userDetails) {

    String username = userDetails.get("username");
    File homedir = new File(System.getProperty("user.home"));
    File file = new File(homedir, "credentials/" + username + "/Key.ppk");
    System.out.println("File Path: "+file.getAbsolutePath());
    System.out.println("File Name: "+file.getName());
    return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
            .header("Content-Disposition", "attachment; filename=" +file.getName()).build();
}