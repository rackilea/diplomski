import java.io.*;

class mdae
{
    public static void main(String[] args)throws IOException
    {
        InputStreamReader cr = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(cr);
        int i, oy,l;
        String s,q,ioo=" ";
        char c,v;
        s=in.readLine();
        s=s.replaceAll("of","");
        q=" "+s+" ";
        l=q.length();
        for(i=0;i<l-1;i++)
        {
            c=q.charAt(i);
            if(c==' ')
            {
                for(oy=i;oy<=i+1;oy++)
                {
                    v=q.charAt(oy);
                    if(v!=' ')
                    {
                        ioo=ioo+v;
                    }
                }
            }
        }
        System.out.print(ioo);
    }
}