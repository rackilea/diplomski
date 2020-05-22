public static void main(String args[])
    {
        FileOutputStream fout = null;
        try
        {
            File f = new File("abc.txt");
            if (!f.isFile())
                f.createNewFile();
            fout = new FileOutputStream(f);
            String s = "Good MOrning";

            byte b[] = s.getBytes();
            fout.write(b);

            System.out.println("success... printed at : " + f.getAbsolutePath());
        } catch (Exception e)
        {
            System.out.println(e);
        } finally
        {
            if (null != fout)
                try
                {
                    fout.close();
                } catch (IOException e)
                {
                }
        }
    }