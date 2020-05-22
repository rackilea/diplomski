public class ChunkedFileResourceHandler implements
    ChunkedFileResourceProcessor.IfaceExt {
....
@Override
public void get_file(String key, String file_name) throws TException {
    // stub
    throw new TException("Wrong call. Use get_file_raw instead.");
}

@Override
public void get_file_raw(String key, String file_name, final TProtocol out)
        throws ServerSideError, TException {
    // catch all here. mimic original get_file throw politics.
    try {
        Logger.me.v("Begin get_file_raw");
        UserSession se = accessUserSession(key, "get", 0, 0);
        vali(se != null);
        synchronized (se) {
            String fullPath = "";
            Logger.me.i("get file start: " + file_name);
            String userDir = AppConfig.getUserDir(se.info.email);
            fullPath = userDir + file_name;

            final FileInputStream inputFile;
            ByteBuffer buffer = null;
            int bytesRead = -1;
            FileChannel fileChannel = null;

            inputFile = new FileInputStream(fullPath);
            fileChannel = inputFile.getChannel();
            buffer = ByteBuffer.allocate(2048);
            bytesRead = fileChannel.read(buffer);

            // Logger.me.v("start sending file");
            while (bytesRead != -1) {
                buffer.flip();
                int length = buffer.limit() - buffer.position()
                        - buffer.arrayOffset();
                Logger.me.v("sending buffer length=" + length);

                out.writeI32(length); // read it in client
                out.writeBinary(buffer); // read it in client
                buffer.clear();

                bytesRead = fileChannel.read(buffer);

            }
            out.writeI32(-1); // read it in client

            Logger.me.i("get file end.");
        }
    } catch (TException e) {
        throw e;
    } catch (Throwable e) {
        write_get_file_exception(file_name, e, out);
        return;
    }

}

void write_get_file_exception(String file, Throwable e, final TProtocol out)
        throws TException {
    out.writeI32(-2);
    out.writeString("Exception in get_file_raw: file=" + file
            + "description=" + e.getMessage());
    Logger.me.e(e);
    Logger.me.i("get file ended wtih errors: " + e.getMessage());
}
}