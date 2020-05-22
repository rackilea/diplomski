Pattern pattern = Pattern.compile("time=(\\d+)ms");
Matcher m = null;
while ((inputLine = in.readLine()) != null) {
    m = pattern.matcher(inputLine);
    if (m.find()) {
        System.out.println(m.group(1));
    }
}