import com.ibm.icu.text.Transliterator;

/**
 * @author Tejas
 */

public class MarathiHelper {

    public String devanagariToLatin(String marathiString) {

        final String MAR_TO_ENG = "Devanagari-Latin";
        //final String DEV_TO_LATIN_NO_ACCENTS = "Devanagari-Latin; nfd; [:nonspacing mark:] remove; nfc";

        Transliterator toEnglish = Transliterator.getInstance(MAR_TO_ENG);
        String english = toEnglish.transliterate(marathiString);

        return english;

    }

    public String latinToDevanagari(String latinString) {

        final String ENG_TO_DEV = "Latin-Devanagari";

        Transliterator toMarathi = Transliterator.getInstance(ENG_TO_DEV);
        String marathi = toMarathi.transliterate(latinString);

        return marathi;
    }

    public String latinToAscii(String latinString){


        final String ENG_TO_DEV = "Latin-ASCII";
        Transliterator toMarathi = Transliterator.getInstance(ENG_TO_DEV);
        String ascii = toMarathi.transliterate(latinString);

        return ascii;

    }

    public String asciiToLatin(String asciiString){

        final String ENG_TO_DEV = "ASCII-Latin";
        Transliterator toMarathi = Transliterator.getInstance(ENG_TO_DEV);
        String latin = toMarathi.transliterate(asciiString);

        return latin;
    }
}