static void Main(string[] args)
    {
        byte[][] addresses = new byte[][] { new byte[] { 10, (byte) 0, (byte) 0, (byte) 138 },
            new byte[] { (byte) 216, (byte) 239, (byte) 49, (byte) 245 },
            new byte []{ 8, (byte) 8, (byte) 8, (byte) 8 } };
        foreach (byte[] addr in addresses)
        {
            IPAddress inet = new IPAddress(addr);
            DateTime before = DateTime.Now;
            String hostName = null;
            try
            {
                hostName = System.Net.Dns.GetHostByAddress(inet).HostName;
            }
            catch { }
            finally
            {
                DateTime after = DateTime.Now;
                Console.WriteLine("{0} {1} {2}", inet.ToString(), hostName!=null?hostName:"N/A", after.Subtract(before));
            }
        }
        Console.ReadLine();
    }