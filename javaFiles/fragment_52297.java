import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiameterUri {

    private String diameterUri;
    private String protocol;
    private String host;
    private String port;
    private String[] params;

    public DiameterUri(String diameterUri) throws URISyntaxException {
        this.diameterUri = diameterUri;
        validate();
        System.out.println(diameterUri);
        System.out.println("  protocol=" + protocol);
        System.out.println("  host=" + host);
        System.out.println("  port=" + port);
        System.out.println("  params=" + Arrays.toString(params));
    }

    private void validate() throws URISyntaxException {
        String protocol = "(aaa|aaas)://";              // protocol- required
        String ip4 = "[A-Za-z0-9.]+";                   // ip4 address - part of "host"
        String ip6 = "\\[::1\\]";                       // ip6 address - part of "host"
        String host = "(" + ip4 + "|" + ip6 + ")";      // host - required
        String port = "(:\\d+)?";                       // port - optional (one occurrence)
        String params = "((;[a-zA-Z0-9]+=[a-zA-Z0-9]+)*)"; // params - optional (multiple occurrences)
        String regEx = protocol + host + port + params;
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(diameterUri);
        if (matcher.matches()) {
            this.protocol = matcher.group(1);
            this.host = matcher.group(2);
            this.port = matcher.group(3) == null ? null : matcher.group(3).substring(1);
            String paramsFromUri = matcher.group(4);
            if (paramsFromUri != null && paramsFromUri.length() > 0) {
                this.params = paramsFromUri.substring(1).split(";");
            } else {
                this.params = new String[0];
            }
        } else {
            throw new URISyntaxException(diameterUri, "invalid");
        }
    }

    public static void main(String[] args) throws URISyntaxException {
        new DiameterUri("aaa://server.com");
        new DiameterUri("aaa://127.0.0.1");
        new DiameterUri("aaa://server.com:1234");
        new DiameterUri("aaas://server.com:1234;transport=tcp");
        new DiameterUri("aaas://[::1]");
        new DiameterUri("aaas://[::1]:1234");
        new DiameterUri("aaas://[::1]:1234;transport=tcp;protocol=diameter");
        try {
            new DiameterUri("127.0.0.1");
            throw new RuntimeException("Expected URISyntaxException");
        } catch (URISyntaxException ignore) {}
    }

}