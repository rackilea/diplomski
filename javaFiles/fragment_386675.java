String data = "({A,B,C},{(A,B),(B,C),(C,A)}),({A,B,C,D,E},{(A,B),(B,C),(C,A),(E,D),(D,A)})";

Pattern pattern = Pattern.compile("\\(\\{([^}]+)\\},\\{([^}]+)\\}\\)");
Matcher matcher = pattern.matcher(data);

while (matcher.find()) {
    System.out.println("Graph vertices=" + matcher.group(1));
    System.out.println("      edges=" + matcher.group(2));
}