@Path("/createCorrespondenceREST")
public class CreateCorrespondenceREST {


    @OPTIONS
    @PermitAll
    public Response options() {
        return Response.ok() //200
                .header("Access-Control-Allow-Origin", "*")             
                .header("Access-Control-Allow-Methods", "GET, OPTIONS")
                .header("Access-Control-Allow-Headers", "Access-Control-Allow-Methods, Access-Control-Allow-Origin, Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers")
                .header("Access-Control-Request-Headers", "Access-Control-Allow-Origin, Content-Type")
                .allow("OPTIONS").build();
    }


   @GET
   @Produces("text/html")
   public Response createCorrespondence(
           @QueryParam("pSource")   java.lang.String pSource,
           @QueryParam("pTemplate") java.lang.String pTemplate,
           @QueryParam("pSourceCode") java.lang.String pSourceCode,
           @QueryParam("pSourceCodeType") java.lang.String pSourceCodeType,
           @QueryParam("pSourceVersion") java.math.BigDecimal pSourceVersion,
           @QueryParam("pRecipient") java.lang.String pRecipient,
           @QueryParam("pLanguage") java.lang.String pLanguage,
           @QueryParam("pSendDate") java.lang.String pSendDate,
           @QueryParam("pBatchNo") java.math.BigDecimal pBatchNo,
           @QueryParam("pHideDocument") java.lang.String pHideDocument,
           @QueryParam("pExternalReference") java.lang.String pExternalReference,
           @QueryParam("pInStr1") java.lang.String pInStr1,
           @QueryParam("pInStr2") java.lang.String pInStr2,
           @QueryParam("pInStr3") java.lang.String pInStr3,
           @QueryParam("pInStr4") java.lang.String pInStr4,
           @QueryParam("pInStr5") java.lang.String pInStr5,
           @QueryParam("pInStr6") java.lang.String pInStr6,
           @QueryParam("pInStr7") java.lang.String pInStr7,
           @QueryParam("pInStr8") java.lang.String pInStr8,
           @QueryParam("pInStr9") java.lang.String pInStr9,
           @QueryParam("pInStr10") java.lang.String pInStr10,
           @QueryParam("pInInt1") java.math.BigDecimal pInInt1,
           @QueryParam("pInInt2") java.math.BigDecimal pInInt2,
           @QueryParam("pInInt3") java.math.BigDecimal pInInt3,
           @QueryParam("pInInt4") java.math.BigDecimal pInInt4,
           @QueryParam("pInInt5") java.math.BigDecimal pInInt5,
           @QueryParam("pInDate1") java.lang.String pInDate1,
           @QueryParam("pInDate2") java.lang.String pInDate2,
           @QueryParam("pInDate3") java.lang.String pInDate3,
           @QueryParam("pInDate4") java.lang.String pInDate4,
           @QueryParam("pInDate5") java.lang.String pInDate5
           ) {



       try {


            String pResponse = callLHHCorrDB.createCorrespondence(pSource,
                    pTemplate,
                    pSourceCode,
                    pSourceCodeType,
                    pSourceVersion,
                    pRecipient,
                    pLanguage,
                    vSendDate,
                    pBatchNo,
                    pHideDocument,
                    pExternalReference,
                    pInStr1,
                    pInStr2,
                    pInStr3,
                    pInStr4,
                    pInStr5,
                    pInStr6,
                    pInStr7,
                    pInStr8,
                    pInStr9,
                    pInStr10,
                    pInInt1,
                    pInInt2,
                    pInInt3,
                    pInInt4,
                    pInInt5,
                    vInDate1,
                    vInDate2,
                    vInDate3,
                    vInDate4,
                    vInDate5);


            return Response.ok() //200
                    .entity(pResponse)
                    .header("Access-Control-Allow-Origin", "*")             
                    .header("Access-Control-Allow-Methods", "GET, OPTIONS")
                    .header("Access-Control-Allow-Headers", "Access-Control-Allow-Methods, Access-Control-Allow-Origin, Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers")
                    .header("Access-Control-Request-Headers", "Access-Control-Allow-Origin, Content-Type")
                    .allow("OPTIONS").build();

    } catch (Exception e) {
        // TODO Auto-generated catch block      
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);
        ps.close();
        return null;    
    }



   }



}