import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.maven.wagon.events.TransferEvent;
import org.apache.maven.wagon.events.TransferListener;

public class WrappedOutputStreamExample extends FileOutputStream {

    private TransferListener transferListener;

    public WrappedOutputStreamExample(File file,TransferListener transferListener) throws FileNotFoundException {
        super(file);
        this.transferListener = transferListener;
    }

    @Override
    public void write(int b) throws IOException {
        super.write(b);
        TransferEvent transferEvent = null; //provide corrent transfer event
        this.transferListener.transferProgress(transferEvent,new byte[]{(byte) b}, 1);
    }

    @Override
    public void write(byte b[]) throws IOException {
        super.write(b);
        TransferEvent transferEvent = null; //provide corrent transfer event
        this.transferListener.transferProgress(transferEvent,b, b.length);
    }

    @Override
    public void write(byte b[], int off, int len) throws IOException {
        TransferEvent transferEvent = null; //provide corrent transfer event

        super.write(b, off, len);
        if (off == 0) {
            this.transferListener.transferProgress(transferEvent,b, len);
        } else {
            byte[] bytes = new byte[len];
            System.arraycopy(b, off, bytes, 0, len);
            this.transferListener.transferProgress(transferEvent,bytes, len);
        }
    }

}