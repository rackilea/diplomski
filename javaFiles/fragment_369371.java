String str = "the consequent hyperglycemia. [10,11][12,13]";

Pattern p = Pattern.compile("\\[.*?\\]");
Matcher m = p.matcher(str);

while (m.find()) {
    str = str.replace(m.group(), m.group().replaceAll("(\\d+)", "{ref$1}")
            .replaceAll("[\\[\\]\\s,]", ""));
}

System.out.println(str);