/*      import java.io.UnsupportedEncodingException;
        import org.apache.commons.codec.DecoderException;
        import org.apache.commons.codec.binary.Hex; //present in commons-codec-1.7.jar
*/
        if (s>= 0 && s < data.length)  {
            String hexString =data[s].trim();
            hexString = hexString.replace("\\x", "");
            byte[] bytes;
            try {
                bytes = Hex.decodeHex(hexString.toCharArray());
                System.out.println("ASCII equivalent : " + new String(bytes, "UTF-8"));
            } catch (DecoderException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }