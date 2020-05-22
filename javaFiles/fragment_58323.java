public String getContentFromFile(String filename)
    {

        StringBuilder s=new StringBuilder();
        try
        {
            InputStream is=getAssets().open(filename);
            BufferedReader br=new BufferedReader(new InputStreamReader(is,Charset.forName("UTF-8")));
            String line;
            while((line=br.readLine())!=null)
            {
                s.append(line).append("\n");

            }

        }catch (Exception | Error e){e.printStackTrace();}
        return s.toString();
   }