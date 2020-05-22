List<Integer> errors = new ArrayList<>();
StringBuilder sb = new StringBuilder();
for (int x = 1; x<10; x++) { 
    errors.add(x);
    sb.append(x).append(",");
}
sb.setLength(sb.length() - 1);
String errorDisplay = sb.toString();