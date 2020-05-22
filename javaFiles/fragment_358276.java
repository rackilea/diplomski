public static Informations findStringAndPosition(String input) {
    Informations infos = new Informations();
    String[] lines = input.split("\n");
    Pattern p = Pattern.compile("^:([^:]+):.*$");
    Matcher m = p.matcher("");

    int lineNumber = 0;
    for (String line : lines) {
        lineNumber++;
        m.reset(line);
        if (m.find()) {
            infos.add(new Info(lineNumber, m.group(1)));
        }
    }

    return infos;
}

static class Informations extends ArrayList<Info> {
    private static final long serialVersionUID = -2872174623287128687L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Info info : this) {
            sb.append(String.format("%s found at line %s\n", info.getString(), info.getPosition()));
        }

        return sb.toString();
    }
}

static class Info {
    private String string;
    private int position;

    public Info(int position, String string) {
        this.string = string;
        this.position = position;
    }

    public final String getString() {
        return string;
    }

    public final int getPosition() {
        return position;
    }
}