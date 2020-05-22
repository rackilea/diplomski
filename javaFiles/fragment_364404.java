import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by aprisadkov on 13.03.2019.
 */
public class QRCodeHelper {
        public static byte[] generateImage(String contents) throws WriterException, IOException {
            return generateImage(contents, 256);
        }

    public static byte[] generateImage(String contents, int size) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "Cp1251");
        hints.put(EncodeHintType.DATA_MATRIX_SHAPE, SymbolShapeHint.FORCE_RECTANGLE);

        BitMatrix bitMatrix = qrCodeWriter.encode(contents, BarcodeFormat.QR_CODE, size, size, hints);
        ByteArrayOutputStream w = new ByteArrayOutputStream(size*size);
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", w);

        return w.toByteArray();
    }
}