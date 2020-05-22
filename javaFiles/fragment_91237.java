import java.util.List;
import com.neovisionaries.i18n.LanguageAlpha3Code;

public class To639_2
{
    public static void main(String[] args)
    {
        // For each language name given on the command line.
        for (String languageName : args)
        {
            // Get a list of ISO 639-2 codes (alpha-3 codes)
            // whose language name matches the given pattern.
            List<LanguageAlpha3Code> list
                = LanguageAlpha3Code.findByName(languageName);

            // Print the language and the ISO 639-2 code.
            System.out.format("%s => %s\n", languageName,
                (list.size() != 0) ? list.get(0) : "");
        }
    }
}