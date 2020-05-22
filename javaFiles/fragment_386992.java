import com.twelvemonkeys.imageio.metadata.AbstractEntry;
import com.twelvemonkeys.imageio.metadata.Entry;
import com.twelvemonkeys.imageio.metadata.exif.EXIFWriter;
import com.twelvemonkeys.imageio.metadata.exif.Rational;
import com.twelvemonkeys.imageio.metadata.exif.TIFF;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.io.*;
import java.util.ArrayList;

public class G3Test {
    public static void main(String[] args) throws IOException {
        File input = new File(args[0]);
        File output = new File(args.length > 1 ? args[1] : input.getName().replace(".g3", ".tif"));

        // ImageWidth = 1728, 2048, 2482. SHORT or LONG. These are the fixed page widths in pixels defined in CCITT Group 3.
        int columns = 1728; // The default
        int rows = 100;     // Trial and error for sample file found at http://www.filesuffix.com/en/extension/fax

        ArrayList<Entry> entries = new ArrayList<>();

        // http://cool.conservation-us.org/bytopic/imaging/std/tiff-f.html
        // Required Class F tags
        entries.add(new TIFFEntry(TIFF.TAG_COMPRESSION, TIFF.TYPE_SHORT, 3)); // CCITT T.4
        entries.add(new TIFFEntry(TIFF.TAG_FILL_ORDER, TIFF.TYPE_SHORT, 1));  // Left to right
        entries.add(new TIFFEntry(TIFF.TAG_GROUP3OPTIONS, TIFF.TYPE_LONG, 0)); // No options set
        entries.add(new TIFFEntry(TIFF.TAG_IMAGE_WIDTH, TIFF.TYPE_LONG, columns));
        entries.add(new TIFFEntry(TIFF.TAG_IMAGE_HEIGHT, TIFF.TYPE_LONG, rows));
        entries.add(new TIFFEntry(TIFF.TAG_SUBFILE_TYPE, TIFF.TYPE_LONG, 2)); // Page
        entries.add(new TIFFEntry(TIFF.TAG_RESOLUTION_UNIT, TIFF.TYPE_SHORT, 2)); // Inches
        entries.add(new TIFFEntry(TIFF.TAG_X_RESOLUTION, TIFF.TYPE_RATIONAL, new Rational(204))); // 204
        entries.add(new TIFFEntry(TIFF.TAG_Y_RESOLUTION, TIFF.TYPE_RATIONAL, new Rational(98))); // 98, 196
        // Required Bilevel (Class B) tags
        entries.add(new TIFFEntry(TIFF.TAG_BITS_PER_SAMPLE, TIFF.TYPE_SHORT, 1)); // 1 bit/sample
        entries.add(new TIFFEntry(TIFF.TAG_PHOTOMETRIC_INTERPRETATION, TIFF.TYPE_SHORT, 0)); // White is zero
        entries.add(new TIFFEntry(TIFF.TAG_SOFTWARE, TIFF.TYPE_ASCII, "TwelveMonkeys FAX2TIFF 0.1 BETA ;-)"));
        entries.add(new TIFFEntry(TIFF.TAG_ROWS_PER_STRIP, TIFF.TYPE_LONG, rows));
        entries.add(new TIFFEntry(TIFF.TAG_SAMPLES_PER_PIXEL, TIFF.TYPE_SHORT, 1)); // 1 sample/pixel
        entries.add(new TIFFEntry(TIFF.TAG_STRIP_BYTE_COUNTS, TIFF.TYPE_LONG, input.length()));
        entries.add(new TIFFEntry(TIFF.TAG_STRIP_OFFSETS, TIFF.TYPE_LONG, -1)); // placeholder for now

        // We now have all our entries, compute size of the entries, and make that the offset (we'll write the data right after).
        EXIFWriter writer = new EXIFWriter();
        long offset = 12 + writer.computeIFDSize(entries); // + 12 for TIFF magic (4), IFD0 pointer (4) and EOF (4)
        entries.remove(entries.size() - 1);
        entries.add(new TIFFEntry(TIFF.TAG_STRIP_OFFSETS, TIFF.TYPE_LONG, offset));


        try (InputStream in = new FileInputStream(input)) {
            try (ImageOutputStream out = ImageIO.createImageOutputStream(output)) {
                // Write the TIFF IFD for the image data
                writer.write(entries, out);

                // Copy the already G3 compressed bytes verbatim to the output
                byte[] buffer = new byte[1024];
                int read;
                while ((read = in.read(buffer)) >= 0) {
                    out.write(buffer, 0, read);
                }
            }
        }
    }

    // API stupidity, should be fixed in later verisons (ie. contain a predefined TIFFEntry class)
    static final class TIFFEntry extends AbstractEntry {
        private final short type;

        TIFFEntry(int identifier, short type, Object value) {
            super(identifier, value);
            this.type = type;
        }

        @Override
        public String getTypeName() {
            return TIFF.TYPE_NAMES[type];
        }
    }
}