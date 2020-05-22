...
public static String armOpener(String answer) {
    switch(answer.toLowerCase()) {
        case "left":
            return "Aha! Indeed the gemstone was hidden in the left hand. Now...";

        case "right":
            return "Bummer! The treasure was in the other hand. Easy for me to say, huh? What if there wasn't a treasure from the start of? Who knows...";

        default:
            return "Did you not hear me boy? I'm asking you, which hand?!";
    }
}
...