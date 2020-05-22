public class HiddenFileServlet extends HttpServlet
{     
  @Inject
  MyService myService; // a service for paths finding on http://file-server

  @Override
  protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws IOException
  {        
    String requestedUri = req.getRequestURI();

    String fileName = myService.getFileName( requestedUri );

    String mime = getServletContext().getMimeType( fileName );

    if ( mime == null )
    {
      resp.setStatus( HttpServletResponse.SC_INTERNAL_SERVER_ERROR );
      return;
    }
    else
    {
      resp.setContentType( mime );
    }

    // path on http://file-server/storage
    URL fileFullPath = myService.getInternalPath( requestedUri );

    URL file = new URL( fileFullPath );

    try (
        InputStream in = file.openStream();
        OutputStream out = resp.getOutputStream()
    )
    {
       org.apache.commons.compress.utils.IOUtils.copy( in, out );
    }
  }
}