public class Sample {

    public static void main(String... args) throws AddressException {
        String to2 = "abctest";
        if (StringUtils.hasText(to2)) {
            InternetAddress[] toia2 = InternetAddress.parse(to2);
            for(InternetAddress address:toia2){
                address.validate();
            }
        }
    }
}