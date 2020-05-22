public static String encodeTest(Object object)
{
    ByteArrayOutputStream bOut = new ByteArrayOutputStream();
    try (OutputStream base64Out = Base64.getUrlEncoder().wrap(bOut);
         Output output = new Output(base64Out))
    {
        KRYO.writeObject(output, object);
    } catch (IOException e)
    {
        // Do nothing, should never happen!
        throw new RuntimeException("MEGA FAIL");
    }

    return bOut.toString();
}