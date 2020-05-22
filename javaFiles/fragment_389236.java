...
public static String armOpener(String answer) {
    String ans = answer.toLowerCase();

    if (ans.equals("left")) {
        return "Aha! Indeed the gemstone was hidden in the left hand. Now...";
    } else if (ans.equals("right")) {
        return "Bummer! The treasure was in the other hand. Easy for me to say, huh? What if there wasn't a treasure from the start of? Who knows...";
    }

    return "Did you not hear me boy? I'm asking you, which hand?!";
}
...