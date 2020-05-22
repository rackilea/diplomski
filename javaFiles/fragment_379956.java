@POST
@Path("upload")
@Consumes(MediaType.APPLICATION_OCTET_STREAM)
public String uploadStream( InputStream payload ) throws IOException
{
    while(true) {
        try {
             DataInputStream dis = new DataInputStream(payload);
            System.out.println(dis.readByte());
        } catch (Exception e) {
            break;
        }
    }
    //Or you can save the inputsream to a file directly, use the code, but must remove the while() above.
  /**
    OutputStream os =new FileOutputStream("C:\recieved.jpg");
    IOUtils.copy(payload,os);
  **/
    System.out.println("Payload size="+payload.available());
    return "Payload size="+payload.available();
}