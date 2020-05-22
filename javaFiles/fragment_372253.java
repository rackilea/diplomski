public class LanguageLoader() {

    final HashMap<String, String> localizedStrings;

    public LanguageLoader(String language) {

        localizedStrings = new HashMap<String, String>();

        File f = new File( "languages/" + language + "/strings.conf" );

        // TODO read file line by line and add key / value pairs to hash map
    }

    public String getStringById( String stringId ) {

        return localizedString.get(stringId);
    }
}