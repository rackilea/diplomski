@RestController
@RequestMapping("/Test")
public class MainController {

    @RequestMapping(value = "/getJsonProperties", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getJsonProperties() {
        Resource resource = new ClassPathResource("/static/configs/properties.json");
        InputStream resourceAsStream;
        JSONObject jsonObject = null;
        JSONArray jsonArray = null;
        String resourceAsString = null;
        try {
            resourceAsStream = resource.getInputStream();
            byte[] resourceInBytes = IOUtils.toByteArray(resourceAsStream);
            resourceAsString = new String(resourceInBytes);
            jsonObject = new JSONObject(resourceAsString);          
            jsonArray = jsonObject.getJSONArray("data");
            System.out.println("json array object is " + jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonArray != null ? jsonArray.toString() : "[]";
    }

}