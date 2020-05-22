import org.codehaus.jackson.map.ObjectMapper;
import my.own.PayloadObject;

...

private static final ObjectMapper MAPPER = new ObjectMapper();

...

private PayloadObject getPayload(HttpServletRequest req) throws IOException
{
    InputStream inputStream = req.getInputStream();
    ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();

    int length;
    byte[] buffer = new byte[1024];

    while ((length = inputStream.read(buffer)) >= 0)
        byteArrayStream.write(buffer, 0, length);

    if (byteArrayStream.size() > 0)
        return MAPPER.readValue(byteArrayStream.toByteArray(), PayloadObject.class);

    return null;
}