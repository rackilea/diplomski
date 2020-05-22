@Path("/download/")
@GET
public javax.ws.rs.core.Response getFile() throws Exception {
    if (/* want the pdf file */) {
        return Response.ok(new File(/*...*/)).type("application/pdf").build(); 
    }

    /* default to xml file */
    return Response.ok(new FileInputStream("custom.xml")).type("application/xml").build();
}