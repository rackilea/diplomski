import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Collection;

import javax.activation.MimetypesFileTypeMap;

import org.apache.tika.detect.Detector;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;

import eu.medsea.mimeutil.MimeUtil;

public class FindMime {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\qwerty\\Desktop\\test.msg");

        System.out.println("urlConnectionGuess " + urlConnectionGuess(file));

        System.out.println("fileContentGuess " + fileContentGuess(file));

        MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();

        System.out.println("mimeTypesMap.getContentType " + mimeTypesMap.getContentType(file));

        System.out.println("mimeutils " + mimeutils(file));

        System.out.println("tika " + tika(file));

    }

    private static String mimeutils(File file) {
        try {
            MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
            MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.ExtensionMimeDetector");
//          MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.OpendesktopMimeDetector");
            MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.WindowsRegistryMimeDetector");
//          MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.TextMimeDetector");
            InputStream is = new BufferedInputStream(new FileInputStream(file));
            Collection<?> mimeTypes = MimeUtil.getMimeTypes(is);
            return mimeTypes.toString();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    private static String tika(File file) {
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(file));
            AutoDetectParser parser = new AutoDetectParser();
            Detector detector = parser.getDetector();
            Metadata md = new Metadata();
            md.add(Metadata.RESOURCE_NAME_KEY, "test.msg");
            MediaType mediaType = detector.detect(is, md);
            return mediaType.toString();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    private static String urlConnectionGuess(File file) {
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        return mimeType;
    }

    private static String fileContentGuess(File file) {
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(file));
            return URLConnection.guessContentTypeFromStream(is);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}