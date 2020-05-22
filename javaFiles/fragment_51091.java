import static org.apache.commons.io.FileUtils.copyURLToFile;
public static void Download() {

        URL dl = null;
        File fl = null;
        try {
            fl = new File(System.getProperty("user.home").replace("\\", "/") + "/Desktop/Screenshots.zip");
            dl = new URL("http://example.com/uploads/Screenshots.zip");
            copyURLToFile(dl, fl);
        } catch (Exception e) {
            System.out.println(e);
        }
    }