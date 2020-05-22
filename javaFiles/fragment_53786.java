public class PrintService {

private static PrintListener printListener;

public enum PaperSize {
    A4,
    A5
}

public static void printPDFFile(final String printerIP, final int printerPort,
                                final File file, final String filename, final PaperSize paperSize, final int copies) {
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            Socket socket = null;
            DataOutputStream out = null;
            FileInputStream inputStream = null;
            try {
                socket = new Socket(printerIP, printerPort);
                out = new DataOutputStream(socket.getOutputStream());
                DataInputStream input = new DataInputStream(socket.getInputStream());
                inputStream = new FileInputStream(file);
                byte[] buffer = new byte[3000];

                final char ESC = 0x1b;
                final String UEL = ESC + "%-12345X";
                final String ESC_SEQ = ESC + "%-12345\r\n";

                out.writeBytes(UEL);
                out.writeBytes("@PJL \r\n");
                out.writeBytes("@PJL JOB NAME = '" + filename + "' \r\n");
                out.writeBytes("@PJL SET PAPER=" + paperSize.name());
                out.writeBytes("@PJL SET COPIES=" + copies);
                out.writeBytes("@PJL ENTER LANGUAGE = PDF\r\n");
                while (inputStream.read(buffer) != -1)
                    out.write(buffer);
                out.writeBytes(ESC_SEQ);
                out.writeBytes("@PJL \r\n");
                out.writeBytes("@PJL RESET \r\n");
                out.writeBytes("@PJL EOJ NAME = '" + filename + "'");
                out.writeBytes(UEL);

                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
                if (printListener != null)
                    printListener.networkError();
            } finally {
                try {
                    if (inputStream != null)
                        inputStream.close();
                    if (out != null)
                        out.close();
                    if (socket != null)
                        socket.close();
                    if (printListener != null)
                        printListener.printCompleted();
                } catch (IOException e) {
                    e.printStackTrace();
                    if (printListener != null)
                        printListener.networkError();
                }
            }
        }
    });
    t.start();
}

public static void setPrintListener(PrintListener list) {
    printListener = list;
}

public interface PrintListener {
    void printCompleted();

    void networkError();
}