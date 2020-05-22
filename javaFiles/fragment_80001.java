public static void sort() throws FileNotFoundException {
    BufferedReader reader;
    try {
        reader = new BufferedReader(new FileReader("data.csv"));
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        throw e;
    }
    Map<MarkAndAttempt, List<String>> map =
            new TreeMap<MarkAndAttempt, List<String>>(new Comparator<MarkAndAttempt>() {
                @Override
                public int compare(MarkAndAttempt o1, MarkAndAttempt o2) {
                    if (o1.getMark() > o2.getMark()) {
                        return -1;
                    } else if (o1.getMark() == o2.getMark()) {
                        return o1.getAttempt() > o2.getAttempt() ? 1 : -1;
                    } else {
                        return 1;
                    }
                }
            });
    String line;
    try {
        reader.readLine();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }//read header
    try {
        while ((line = reader.readLine()) != null) {
            //String key = getField(line);

            //List<String> l = map.get(key);

            MarkAndAttempt markAndAttempt = generateMarkAndAttempt(line);
            List<String> l = map.get(markAndAttempt);

            if (l == null) {
                l = new LinkedList<String>();
                map.put(markAndAttempt, l);
            }
            l.add(line);
        }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    try {
        reader.close();
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }

    System.out.println("HALL OF FAME\nMatric, Marks, Attempt");

    for (List<String> list : map.values()) {
        for (String val : list) {
            System.out.println(val);
        }



    }
}


private static MarkAndAttempt generateMarkAndAttempt(String line) {
    Objects.requireNonNull(line);
    String[] parts = line.split(",");
    if (parts.length != 3) throw new IllegalArgumentException("");
    return new MarkAndAttempt(Integer.valueOf(parts[1].trim()), Integer.valueOf(parts[2].trim()));
}

private static String getField(String line) {
    return line.split(",")[1];// extract value you want to sort on
}

static class MarkAndAttempt {

    private int mark;

    private int attempt;

    public MarkAndAttempt(int mark, int attempt) {
        this.mark = mark;
        this.attempt = attempt;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarkAndAttempt that = (MarkAndAttempt) o;

        return mark == that.mark;

    }

    @Override
    public int hashCode() {
        return mark;
    }
}