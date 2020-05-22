import java.io.*;
import java.util.*;

public class Translator {

    public enum Language {
        EN, ES
    }

    private static final String TRANSLATION_TEMPLATE = "translation_%s_%s.properties";
    private final Properties translations = new Properties();

    public Translator(Language from, Language to) {
        String translationFile = String.format(TRANSLATION_TEMPLATE, from, to);
        try (InputStream is = getClass().getResourceAsStream(translationFile)) {
            translations.load(is);
        } catch (final IOException e) {
            throw new RuntimeException("Could not read: " + translationFile, e);
        }
    }

    private String[] translate(String text) {
        String[] source = normalizeText(text);
        List<String> translation = new ArrayList<>();
        for (String sourceWord : source) {
            translation.add(translateWord(sourceWord));
        }
        return translation.toArray(new String[source.length]);
    }

    private String translateWord(String sourceWord) {
        Object value = translations.get(sourceWord);
        String translatedWord;
        if (value != null) {
            translatedWord = String.valueOf(value);
        }
        else {
            // if no translation is found, add the source word with a question mark
            translatedWord = sourceWord + "?";
        }
        return translatedWord;
    }

    private String[] normalizeText(String text) {
        String alphaText = text.replaceAll("[^A-Za-z]", " ");
        return alphaText.split("\\s+");
    }

    public static void main(final String[] args) {
        final Translator translator = new Translator(Language.EN, Language.ES);
        System.out.println(Arrays.toString(translator.translate("hello world!")));
    }
}