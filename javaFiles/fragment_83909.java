public static long getAvailableMem()
{
    String osName = System.getProperty("os.name");
    if (osName.equals("Linux"))
    {
        try {
            BufferedReader memInfo = new BufferedReader(new FileReader("/proc/meminfo"));
            String line;
            while ((line = memInfo.readLine()) != null)
            {
                if (line.startsWith("MemAvailable: "))
                {
                    // Output is in KB which is close enough.
                    return java.lang.Long.parseLong(line.split("[^0-9]+")[1]) * 1024;
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    // We can also add checks for freebsd and sunos which have different ways of getting available memory
    } else
    {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        com.sun.management.OperatingSystemMXBean sunOsBean = (com.sun.management.OperatingSystemMXBean)osBean;
        return sunOsBean.getFreePhysicalMemorySize();
    }
    return -1;
}