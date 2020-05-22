public class Dictionary {

    private Word check, it, out;

    Dictionary() {

        check = new Verb("check", "prüfen", "tester");
        it = new Pronoun("it", "es", "le");
        out = new Preposition("out", "hinaus", "dehors");

        try {
            System.out.print(check.translateTo(Language.German));
            System.out.print(it.translateTo(Language.German));
            System.out.print(out.translateTo(Language.German));
        } catch (Exception whatever) {
            whatever.printStackTrace();
        }
    }
}