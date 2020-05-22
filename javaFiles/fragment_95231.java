import java.util.*;
import java.util.stream.Collectors;

public class MessagesResourceBundle {
    private static final String BASE_NAME = "messages";
    private static final List<String> LOCALES = Arrays.asList("en", "fr");
    private Map<Locale, Map<String, String>> allMessages;

    public MessagesResourceBundle() {
        allMessages = new HashMap<>();
        List<Locale> locales = LOCALES.stream().map(Locale::new).collect(Collectors.toList());
        locales.add(Locale.ROOT);
        locales.stream().map(l -> ResourceBundle.getBundle(BASE_NAME, l))
                .forEach(bundle -> {
                    Map<String, String> messages = new HashMap<>();
                    Collections.list(bundle.getKeys()).forEach(key -> messages.put(key, bundle.getString(key)));
                    allMessages.put(bundle.getLocale(), messages);
                });
    }

    public Map<Locale, Map<String, String>> getAllMessages() {
        return Collections.unmodifiableMap(allMessages);
    }
}