class FileBodyCounter extends FileBody {
    private volatile long byteCount;
    private volatile CloudStatusListener listener;
    private volatile long totalnum;

    public FileBodyCounter(File file,CloudStatusListener listener,long totalnum) {
        super(file);
        this.listener=listener;
        this.totalnum=totalnum;
    }

    public long getBytesWritten() {
        return byteCount;
    }

    @Override
    public void writeTo(OutputStream out) throws IOException {
        super.writeTo(new FilterOutputStream(out) {
            //
            // Other write() methods omitted for brevity. 
            // Implement for better performance
            public void write(int b) throws IOException {
                 byteCount++;
                 super.write(b);
                 if (byteCount % listener.progressInterval() == 0 ||
                    byteCount == totalnum){
                    listener.onProgress(byteCount,totalnum);
                }
            }
        });
    }

}