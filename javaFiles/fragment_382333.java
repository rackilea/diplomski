Pattern pattern = Pattern.compile("<([^>]+)>([^<]*)</[^>]+>");
try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            System.out.printf("%s: %s ", matcher.group(2).trim(), matcher.group(1));
        }
        System.out.println();
    }
}