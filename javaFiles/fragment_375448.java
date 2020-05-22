String s = "Beach Video @instagram.mp4";
Pattern p = Pattern.compile("(.*)\\s*(@[^.]+).*");
Matcher m = p.matcher(s);
if (m.matches()) {
    System.out.println("First part: " + m.group(1));
    System.out.println("Second part: Source " + m.group(2));
} else {
    System.out.println("Unexpected file format");
}