Pattern pattern = Pattern.compile("(?<=\\d\\s)\\d{2}(?=\\s\\d)");
Matcher m = pattern.matcher(line);
while (m.find()) {
    value = Integer.parseInt(m.group().trim());
}
line = line.replaceAll("(?<=\\d\\s)\\d{2}(?=\\s\\d)", "").replaceAll(" +", " ");
System.out.println(line);