String filename = "01. Kodaline - Autopilot.mp3";
String regex = "^(.*)\\.(.*)\\-(.*)\\.(mp3|flac)";

Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(filename);

String[] metadata = new String[4];
if (matcher.find()) {
    metadata[0] = matcher.group(1); // in real life I'd use a loop
    metadata[1] = matcher.group(2);
    metadata[2] = matcher.group(3);
    metadata[3] = matcher.group(4);
    // the rest of your code
}