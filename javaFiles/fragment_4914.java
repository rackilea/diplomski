@Path("/vsp")
public class SampleService{

    @Path("/save")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void saveProfile(@Context HttpServletRequest request, 
            @Context HttpServletResponse response) throws Exception {

        // getting the uploaded files
        ArrayList<FileItem> items = (ArrayList<FileItem>)request.getAttribute("files");
        FileItem item = items.get(0);
        String name = new File(item.getName()).getName();
        item.write( new File("C:" + File.separator + name));

        // getting the data
        String modelString = (String)request.getAttribute("model");

        // Getting JSON from model string
        JSONObject obj = JSONObject.parse(modelString);

        String responseString = "model.name: " + obj.get("name") + " and " + items.size() + " file(s) received";
        System.out.println(responseString);
    }

}