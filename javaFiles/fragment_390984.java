public class Message {

    public String sender;

    public String time;

    public String message;

    public String plainMessage;

    public Message(String line) {
        String[] array = line.split("]");

        time = clean(array[0].replace("[", ""));

        array = Main.removeElements(array, array[0]);

        line = Main.join("]", array);

        array = line.split(":");

        sender = clean(array[0]);

        array = Main.removeElements(array, array[0]);

        line = Main.join(":", array);

        plainMessage = line;

        line = StringEscapeUtils.escapeJava(line);
        line = escapeUmlaut(line);

        message = StringEscapeUtils.escapeJson(line);
    }

    private String escapeUmlaut(String input) {
        String output = input.replace("ü", "ue")
                .replace("ö", "oe")
                .replace("ä", "ae")
                .replace("ß", "ss");

        output = output.replace("Ü(?=[a-zäöüß ])", "Ue")
                .replace("Ö(?=[a-zäöüß ])", "Oe")
                .replace("Ä(?=[a-zäöüß ])", "Ae");

        output = output.replace("Ü", "UE")
                .replace("Ö", "OE")
                .replace("Ä", "AE");

        return output;
    }

    public static String clean(String what) {
        char[] chars = what.toCharArray();
        what = "";
        char[] allowed = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890[](){}=?!\\§$%&/'#*+;,:.-_<>|".toCharArray();
        for (char c : chars) {
            for (char cc : allowed) {
                if (cc == c) {
                    what += c;
                }
            }
        }

        return what;
    }

}