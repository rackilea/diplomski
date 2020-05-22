public synchronized void printLinkStatistics(Logger log, PrintWriter writer)
{
    log.info("\tInput Port = " + inputPort);
    Set <Long> ts = statData.keySet();
    for(Long t: ts)
    {   double utilization = statData.get(t);
        if (utilization!=0.0) 
        {
            utilization *= 8.0;
            utilization /= 1e6;
            if (!Double.isNaN(utilization))
            {
            log.info("\t\tTimestamp = " + t + ", Utilization = " + utilization + "Mbps");
      writer.println("\t\tTimestamp = " + t + ", Utilization = " + utilization + "Mbps");

           }
        }
    }
    writer.flush();
}