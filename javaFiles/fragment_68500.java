public enum Service
{
    LOGIN,
    REGISTER,
    NEWS;

    private final long LOADED, FAILED;

    private RequestType()
    {
        LOADED  = strToAscii(this.name() + "_LOADED"  );
        FAILED = strToAscii(this.name() + "_FAILED"  );            
    }

    public static long strToAscii(String str)
    {
       StringBuilder sb = new StringBuilder();

       for (char c: str.toCharArray() )
       {
           sb.append( (int) c );
       }

      return Long.parseLong( sb.toString() );
   }
}