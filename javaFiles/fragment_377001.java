class VFSModule extends AbstractQuercusModule
{

    FileSystemManager fsManager = VFS.getManager();

    public Object vfs_fopen(String filename, String mode) {            
        FileObject file =  fsManager.resolveFile(filename);
        if (mode.equals("r"))
            return file.getContent().getInputStream();
        else if (mode.equals("w"))
            return file.getContent().getOutputStream();
        throw new IllegalArgumentException("unsupported mode; "+mode);                
    }

    function String vfs_fread(Object stream, int length) {
        InputStream in = (InputStream)stream;
        byte[] buffer = new byte[length];
        int read = in.read(buffer);
        // todo - handle smaller than length reads
        return buffer;
    }

    function void vfs_fwrite(Object stream, int length, byte[] data) {
        OutputStream out = (OutputStream)stream;
        out.write(data);
    }

}