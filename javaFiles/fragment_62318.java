String cmd = "mailq | grep -B1 -i temporarily | grep -iv deferred | "
              +"egrep -i 'jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec' |" 
              + " \'{print $1}\' | awk \'{print  substr($0,10,14)}\'";
    try
    {
      ProcessBuilder pb = new ProcessBuilder("bash", "-c", cmd);
      Process p = pb.start();
      p.destroy();
    }
    catch (Exception e)
    {e.printStackTrace();}