import java.net.*;
import java.io.*;
import java.util.zip.GZIPInputStream;
import net.sf.samtools.util.BlockCompressedInputStream;
public class Test
    {
    public static void main(String args[]) throws Exception
        {
        URL url=new URL("ftp://ftp.1000genomes.ebi.ac.uk/vol1/ftp/release/20100804/ALL.2of4intersection.20100804.sites.vcf.gz");
        String line;
        int nRead=0;
        BufferedReader in= new BufferedReader(new InputStreamReader(new BlockCompressedInputStream(url.openStream())));
        while((line=in.readLine())!=null)
            {
            System.out.println(line);
            }
        in.close();
        System.out.println("Done.");
        }
    }