String input = br.readLine();
// Compile you pattern with two groups to capture each num
Pattern pattern = Pattern.compile("\\((\\d+(\\.\\d+)?),(\\d+(\\.\\d+)?)\\)");
// Match your input
Matcher matcher = pattern.matcher(input);
// If your input matches to pattern you want, then you take numbers
if (matcher.find()) {
    double x = Double.parseDouble(matcher.group(1);
    double y = Double.parseDouble(matcher.group(3);
    //... Other code you need
}