private static MWMCR mcr= null;
static Plotter()
{
  if (MWMCR.MCRAppInitialized)
  {
    try
    {
      /* a lot of codes here but deleted to make what is important stands out */
      mcr= new MWMCR("",
                     ctfFilePath, embeddedCtfStream, true);
    }
    catch(Exception ex) { //some code here }
  }
}

public Plotter()
{
  if(ex_ != null)
  {
    throw ex_;
  }
}