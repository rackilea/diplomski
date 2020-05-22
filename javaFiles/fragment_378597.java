// reuse the same marshaller wired in RestTemplate
@Autowired
private Jaxb2Marshaller jaxb2Marshaller;

public Object genericPost(String url) {
    // using Commons HttpClient
    HttpClient client = new HttpClient();
    PostMethod method = new PostMethod(url);

    // add your data here
    method.addParameter("data", "your-data");

    try {
        int returnCode = client.executeMethod(method);

        // status code is 200
        if (returnCode == HttpStatus.SC_OK) {
            // using Commons IO to convert inputstream to string
            String xml = IOUtil.toString(method.getResponseBodyAsStream());
            return jaxb2Marshaller.unmarshal(new StreamSource(new ByteArrayInputStream(xml.getBytes("UTF-8"))));
        }
        else {
            // handle error
        }
    }
    catch (Exception e) {
        throw new RuntimeException(e);
    }
    finally {
        method.releaseConnection();
    }

    return null;
}