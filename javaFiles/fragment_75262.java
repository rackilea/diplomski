String parse = "<HTMLCODE>My favourite pasta is spaghetti, followed by ravioli</HTMLCODE>";

final char TAG_START = '<';
final char TAG_END = '>';

StringBuilder sb = new StringBuilder();

char[] parseChars = parse.toCharArray();

boolean inTag = true;
for (int i = 0; i< parseChars.length; i++) {
    if (parseChars[i] == TAG_START) {
        inTag = true;
        continue;
    }
    else if (parseChars[i] == TAG_END) {
        inTag = false;
        continue;
    }
    if (!inTag) {
        sb.append(parseChars[i]);
    }
}

System.out.println(sb.toString());