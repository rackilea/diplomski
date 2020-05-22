import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Version {
    private static final Pattern SERVER_NAME_PATTERN = Pattern.compile("(\\w+)-(\\d+)\\.lan");

    final String server;
    final List<Job> jobs;

    final String serverName;
    final int serverNumber;

    Version(String server, List<Job> jobs) {
        this.server = server;
        this.jobs = List.copyOf(jobs);

        Matcher matcher = SERVER_NAME_PATTERN.matcher(server);
        if (matcher.matches()) {
            this.serverName = matcher.group(1).toUpperCase(Locale.US);
            this.serverNumber = Integer.parseInt(matcher.group(2));
        } else {
            throw new IllegalArgumentException("Invalid server: " + server);
        }
    }
}