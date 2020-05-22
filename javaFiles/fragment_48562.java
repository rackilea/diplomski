@Path("/multipart")
public class MultipartResource {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response postData(MultipartFormDataInput input) throws Exception {

        byte[] bytes = input.getFormDataPart("file", byte[].class, null);
        JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(bytes)));

        return Response.ok("GOT IT").build();
    }
}