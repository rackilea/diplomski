public static void main(String[] argv) throws Exception
{

    System.out.println("1");
    for(int i=0;i<argv.length;i++)
    {
        if (argv[i].equals("-h"))
        {
            System.out.println("-ip   target ip address\n");
            System.out.println("-t    time interval between each scan in milliseconds\n");
            System.out.println("-p    protocol type [UDP/TCP/ICMP]\n");
            System.out.println("-type scan type [full,stealth,fin,ack]\n");
            System.out.println("-b    bannerGrabber status\n");

        }
     }
}