public class WrappedInputStream extends InputStream{

        InputStream is;
        HttpURLConnection urlconn;

        public WarppedInputStream(InputStream is, HttpURLConnection urlconn){
            this.is = is;
            this.urlconn = urlconn;
        }

        @Override
        public int read() throws IOException{
            int read = this.is.read();
            if (read != -1){
                return read;
            }else{
                is.close();
                urlconn.disconnect();
                return -1;
            }
        }

        @Override
        public int read(byte[] b) throws IOException{
            int read = this.is.read(b);
            if (read != -1){
                return read;
            }else{
                is.close();
                urlconn.disconnect();
                return -1;
            }
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException{
            int read = this.is.read(b, off, len);
            if (read != -1){
                return read;
            }else{
                is.close();
                urlconn.disconnect();
                return -1;
            }
        }
    }