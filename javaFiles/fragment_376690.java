@Path("/Integracao")
public class Integracao {

@Context
private HttpServletRequest httpServletRequest;

@GET
@Path("/gerarPdf")
public Response geraPDF(@QueryParam("relatorio") String arquivoJrxml,
                        @QueryParam("autorizacao") String autorizacao){

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    Map fillParams = new HashMap(); 
    fillParams.put("IMPRAUTORIZACAO", autorizacao);
    PdfGenerator pdf = new PdfGenerator();
    byte[] bytes= pdf.generateJasperReportPDF(httpServletRequest, arquivoJrxml, outputStream, fillParams);

    String nomeRelatorio= arquivoJrxml + ".pdf";
    return Response.ok(bytes).type("application/pdf").header("Content-Disposition", "filename=\"" + nomeRelatorio + "\"").build();
}