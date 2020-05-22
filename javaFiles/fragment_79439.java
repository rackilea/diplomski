Scanner scanner = new Scanner(new File("file.txt"));
scanner.useDelimiter("TSNK/Metadata/");

Pattern p = Pattern.compile("(.*)=(.*)", Pattern.DOTALL | Pattern.MULTILINE);

String s = null;
do {
    if (scanner.hasNext()) {
        s = scanner.next();
        Matcher matcher = p.matcher(s);
        if (matcher.find()) {
            System.out.println("key = '" + matcher.group(1) + "'");
            String[] values = matcher.group(2).split("[,\n]");
            int i = 1;
            for (String value : values) {
                System.out.println(String.format(" val(%d)='%s',", (i++), value ));
            }
        }
    }
} while (s != null);