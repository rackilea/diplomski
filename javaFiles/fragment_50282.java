ServerGateway sg = JAXRSClientFactory.create(
            "http://localhost:8090",
            ServerGateway.class);

    String rawXml = sg.getRawXML().replaceAll("\n|\r", "");



public interface ServerGateway {

@GET
@Produces("text/xml")
@Path("/MyServer/xv/test/test2/test33/test4.xml")
public String getRawXML();

}