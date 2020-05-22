@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("xyz")
public *String* pqr() throws IOException {

    ABC abc = new ABC();
    abc.setOutputStream(response.getOutputStream());

    String fileName = abc.getFileName();
    //fileName = "results.csv"
    response.setContentType("text/csv");

    response.setHeader("Content-Disposition","attachment;filename=\"" + fileName + "\"");

    return *""*;
}