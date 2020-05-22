public class CardCreator {

public static String MembershipCard(String path) throws IOException {
    String ImgUrl = "";
    Image image = null;
    // Read from an input stream
    InputStream is = new BufferedInputStream(new FileInputStream(path + "/img/membershipcard.png"));

    ...

    return ImgUrl;
}