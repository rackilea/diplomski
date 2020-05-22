public class WordWrapper {

    public String wrapWords(String input, int lines) {
        return splitWords(input.replaceAll("\\s+", " "), lines);
    }

    private String splitWords(String input, int lines) {
        if (lines <= 1) {
            return input;
        }

        int splitPointHigh = findSplit(input, lines, 1);
        String splitHigh = input.substring(0, splitPointHigh).trim() + "\n" + splitWords(input.substring(splitPointHigh).trim(), lines - 1);

        int splitPointLow = findSplit(input, lines, -1);
        String splitLow = input.substring(0, splitPointLow).trim() + "\n" + splitWords(input.substring(splitPointLow).trim(), lines - 1);

        if (maxLineLength(splitLow) < maxLineLength(splitHigh))
            return splitLow;
        else return splitHigh;
    }

    private int maxLineLength(String split) {
        return maxLength(split.split("\n"));
    }

    private int maxLength(String[] lines) {
        int maxLength = 0;
        for (String line: lines) {
            if (line.length() > maxLength)
                maxLength = line.length();
        }
        return maxLength;
    }

    private int findSplit(String input, int lines, int dir) {
        int result = input.length() / lines;
        while (input.charAt(result) != ' ')
            result+= dir;
        return result;
    }
}