Clob clobObject = (Clob)rs.getObject("name");                                       
            final StringBuilder sb = new StringBuilder();
            try
                {
                    final Reader reader = clobObject.getCharacterStream();
                    final BufferedReader br = new BufferedReader(reader);
                    int b;
                    while(-1 != (b = br.read()))
                    {
                        sb.append((char)b);
                    }
                    br.close();
                    String theName = sb.toString();
            catch (Exception ex)
            {

            }