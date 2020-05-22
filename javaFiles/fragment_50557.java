import java.io.IOException;
import javax.activation.*;

public class SystemDataHandlerConfigurator {

    public void setupCustomDataContentHandlers() {

        DataHandler.setDataContentHandlerFactory(new CustomDCHFactory());
    }

    private class CustomDCHFactory implements DataContentHandlerFactory {

        @Override
        public DataContentHandler createDataContentHandler(String mimeType) {

            return new BinaryDataHandler();
        }
    }

    private class BinaryDataHandler implements DataContentHandler {

        /** Creates a new instance of BinaryDataHandler */
        public BinaryDataHandler() {

        }

        /** This is the key, it just returns the data uninterpreted. */
        public Object getContent(javax.activation.DataSource dataSource) throws java.io.IOException {

                return dataSource.getInputStream();
        }

        public Object getTransferData(java.awt.datatransfer.DataFlavor dataFlavor, 
                             javax.activation.DataSource dataSource) 
                              throws java.awt.datatransfer.UnsupportedFlavorException, 
       java.io.IOException {

                return null;
        }

        public java.awt.datatransfer.DataFlavor[] getTransferDataFlavors() {

            return new java.awt.datatransfer.DataFlavor[0];
        }

        public void writeTo(Object obj, String mimeType, java.io.OutputStream outputStream) 
         throws java.io.IOException {

                if (mimeType == "text/plain") {
                    byte[] stringByte = (byte[]) ((String) obj).getBytes("UTF-8");
                    outputStream.write(stringByte);
                }
                else {
                    throw new IOException("Unsupported Data Type: " + mimeType);
                }
        }
    }  
}