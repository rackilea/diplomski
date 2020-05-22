public class Main {
    public static void main(String[] args) throws Exception {
        Client client = ClientBuilder.newClient();
        String url = "http://localhost:8080/api/test";
        Response response = client.target(url).request().get();
        String location = "some_location";
        FileOutputStream out = new FileOutputStream(location);
        InputStream is = (InputStream)response.getEntity();
        int len = 0;
        byte[] buffer = new byte[4096];
        while((len = is.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        out.flush();
        out.close();
        is.close();
    }
}