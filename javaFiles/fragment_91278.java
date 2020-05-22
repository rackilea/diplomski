public static void copyStream(InputStream is, OutputStream os)
    {
        byte[] buff = new byte[4096];
        int count;
        try {
            while((count = is.read(buff)) > 0)
                os.write(buff, 0, count);

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }