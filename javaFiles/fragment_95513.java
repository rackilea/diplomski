public class ImageDownloaderInputStream extends InputStream {
    private byte[] buffer = null;
    private int bufLen = 0;
    private int bufIndex = 0;
    private boolean isContentValid;
    private InputStream wrapped;

    public ImageDownloaderInputStream (InputStream wrapped) {
         this.wrapped = wrapped;
    }

    @Override
    public ind read() {
        if(buffer == null) {
            // check content and fill buffer
            this.isContentValid = checkContent();
        }
        if (this.isContentValid) {
            if(bufIndex < bufLen) {
                return buffer[bufIndex++] & 0xFF;
            } else {
                 return wrapped.read();
            }
        } else {
            // error handling: zero-length stream
            return -1;
        }
    }

    private boolean checkContent() {
        // fill the buffer
        this.buffer = new byte[1024];
        this.bufLen = wrapped.read(this.buffer); 
        // read more if not enough

        // check the content
        return true;
        // return false;      
    }
}