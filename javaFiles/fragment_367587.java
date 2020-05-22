public class MyTai implements TrustAssociationInterceptor {
    @Override
    public TAIResult negotiateValidateandEstablishTrust(HttpServletRequest req,
            HttpServletResponse res) throws WebTrustAssociationFailedException {
        // pseudo code
        ....
        if(requestShouldRedirect) {
            res.sendRedirect("URL_TO_REDIRECT");
            return TAIResult.create(HttpServletResponse.SC_CONTINUE);

        }
        else // finalize authentication
            ....