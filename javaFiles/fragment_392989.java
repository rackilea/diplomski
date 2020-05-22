List<String> values = new ArrayList<>();
values.add("APAC");
values.add("North America");
values.add("South America");
values.add("Europe");

System.out.println(values);

StringBuilder sb = new StringBuilder(128);
for (String value : values) {
    if (sb.length() > 0) {
        sb.append(",");
    }
    sb.append(value);
}
sb.insert(0, "[");
sb.append("]");

System.out.println(sb);