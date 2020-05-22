public class CachedServletInputStream extends ServletInputStream {

    private File m_TemporaryFile;
    private InputStream m_InputStream;


    public CachedServletInputStream(File temporaryFile) throws IOException {
        m_TemporaryFile = temporaryFile;
        m_InputStream = null;
    }


    private InputStream acquireInputStream() throws IOException {
        if(m_InputStream == null) {
            m_InputStream = new FileInputStream(m_TemporaryFile);
        }

        return m_InputStream;
    }


    public void close() throws IOException {
        try {
            if(m_InputStream != null) {
                m_InputStream.close();
            }
        }
        catch(IOException e) {
            throw e;
        }
        finally {
            m_InputStream = null;
        }
    }


    public int read() throws IOException {
        return acquireInputStream().read();
    }


    public boolean markSupported() {
        return false;
    }


    public synchronized void mark(int i) {
        throw new UnsupportedOperationException("mark not supported");
    }


    public synchronized void reset() throws IOException {
        throw new IOException(new UnsupportedOperationException("reset not supported"));
    }
}