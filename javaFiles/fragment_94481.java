public class CachedHttpServletRequest extends HttpServletRequestWrapper
{

    public static final String TEMPORARY_FILENAME_PREFIX = "MyPrefix";
    public static final String TEMPORARY_FILENAME_SUFFIX = ".cache";

    public static final int LEN_BUFFER = 32768; //32 KB


    private File m_TemporaryFile;


    public CachedHttpServletRequest(HttpServletRequest httpServletRequest, File temporaryFolder)
        throws ServletException {

        super(httpServletRequest);

        try {
            //Create a temporary file to hold the contents of the request's input stream
            m_TemporaryFile = File.createTempFile(TEMPORARY_FILENAME_PREFIX, null, temporaryFolder);

            //Copy the request body to the temporary file
            BufferedInputStream is = new BufferedInputStream(super.getInputStream());
            FileOutputStream os = new FileOutputStream(m_TemporaryFile);
            byte[] buffer = new byte[LEN_BUFFER];
            int bytesWritten = 0;
            int bytesRead = is.read(buffer);
            while(bytesRead != -1) {
                os.write(buffer, 0, bytesRead);
                bytesWritten += bytesRead;
                bytesRead = is.read(buffer);
            }
            is.close();
            os.close();
        }
        catch(Exception e) {
            throw new ServletException(e);
        }
   }


   public void cleanup() {
        m_TemporaryFile.delete();
   }


   @Override
   public ServletInputStream getInputStream() throws IOException {
       return new CachedServletInputStream(m_TemporaryFile);
   }


   @Override
   public BufferedReader getReader() throws IOException {
       String enc = getCharacterEncoding();
       if(enc == null) enc = "UTF-8";
       return new BufferedReader(new InputStreamReader(getInputStream(), enc));
   }
}