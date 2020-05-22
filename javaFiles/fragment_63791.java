//This is the actual filter
public class PDFFilter implements Filter 
{
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException 
    {
        PDFPasswordInjector pdfPassInject = new PDFPasswordInjector();
        //use HttpServletRequestWrapper to get the pdf location/pdf name
        pdfPassInject.injectPassword( "<pdf location>" );

        chain.doFilter(request, response);
    }
}

//Java class to inject the password
public class PDFPasswordInjector
{
    public boolean injectPassword( String sPDFName )
        {
                // retrieve password from DB
                // use API to inject password to PDF
        }
}