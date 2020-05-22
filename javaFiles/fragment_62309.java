package com.ziesemer.test;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.media.Duration;
import javax.media.MediaLocator;
import javax.media.Time;
import javax.media.protocol.ContentDescriptor;
import javax.media.protocol.PullDataSource;
import javax.media.protocol.PullSourceStream;
import javax.media.protocol.Seekable;

/**
 * @author Mark A. Ziesemer
 *  <a href="http://www.ziesemer.com.">&lt;www.ziesemer.com&gt;</a>
 */
public class JarDataSource extends PullDataSource{

    protected JarURLConnection conn;
    protected ContentDescriptor contentType;
    protected JarPullSourceStream[] sources;
    protected boolean connected;

    public JarDataSource(URL url) throws IOException{
        setLocator(new MediaLocator(url));
        connected = false;
    }

    @Override
    public PullSourceStream[] getStreams(){
        return sources;
    }

    @Override
    public void connect() throws IOException{
        conn = (JarURLConnection)getLocator().getURL().openConnection();
        conn.connect();
        connected = true;

        JarFile jf = conn.getJarFile();
        JarEntry je = jf.getJarEntry(conn.getEntryName());

        String mimeType = conn.getContentType();
        if(mimeType == null){
            mimeType = ContentDescriptor.CONTENT_UNKNOWN;
        }
        contentType = new ContentDescriptor(ContentDescriptor.mimeTypeToPackageName(mimeType));

        sources = new JarPullSourceStream[1];
        sources[0] = new JarPullSourceStream(jf, je, contentType);
    }

    @Override
    public String getContentType(){
        return contentType.getContentType();
    }

    @Override
    public void disconnect(){
        if(connected){
            try{
                sources[0].close();
            }catch(IOException e){
                e.printStackTrace();
            }
            connected = false;
        }
    }

    @Override
    public void start() throws IOException{
        // Nothing to do.
    }

    @Override
    public void stop() throws IOException{
        // Nothing to do.
    }

    @Override
    public Time getDuration(){
        return Duration.DURATION_UNKNOWN;
    }

    @Override
    public Object[] getControls(){
        return new Object[0];
    }

    @Override
    public Object getControl(String controlName){
        return null;
    }

    protected class JarPullSourceStream implements PullSourceStream, Seekable, Closeable{

        protected final JarFile jarFile;
        protected final JarEntry jarEntry;
        protected final ContentDescriptor type;

        protected InputStream stream;
        protected long position;

        public JarPullSourceStream(JarFile jarFile, JarEntry jarEntry, ContentDescriptor type) throws IOException{
            this.jarFile = jarFile;
            this.jarEntry = jarEntry;
            this.type = type;
            this.stream = jarFile.getInputStream(jarEntry);
        }

        @Override
        public ContentDescriptor getContentDescriptor(){
            return type;
        }

        @Override
        public long getContentLength(){
            return jarEntry.getSize();
        }

        @Override
        public boolean endOfStream(){
            return position < getContentLength();
        }

        @Override
        public Object[] getControls(){
            return new Object[0];
        }

        @Override
        public Object getControl(String controlType){
            return null;
        }

        @Override
        public boolean willReadBlock(){
            if(endOfStream()){
                return true;
            }
            try{
                return stream.available() == 0;
            }catch(IOException e){
                return true;
            }
        }

        @Override
        public int read(byte[] buffer, int offset, int length) throws IOException{
            int read = stream.read(buffer, offset, length);
            position += read;
            return read;
        }

        @Override
        public long seek(long where){
            try{
                if(where < position){
                    stream.close();
                    stream = jarFile.getInputStream(jarEntry);
                    position = 0;
                }
                long skip = where - position;
                while(skip > 0){
                    long skipped = stream.skip(skip);
                    skip -= skipped;
                    position += skipped;
                }
            }catch(IOException ioe){
                // Made a best effort.
                ioe.printStackTrace();
            }
            return position;
        }

        @Override
        public long tell(){
            return position;
        }

        @Override
        public boolean isRandomAccess(){
            return true;
        }

        @Override
        public void close() throws IOException{
            try{
                stream.close();
            }finally{
                jarFile.close();
            }
        }

    }

}