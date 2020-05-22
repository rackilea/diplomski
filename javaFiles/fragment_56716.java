String example = "ATS0657882\nPRX1686559\n name: something,hello";
Pattern p = Pattern.compile("[A-Z]{3}[0-9]{7}"); // or [A-Z]{3}\\d{7}
Matcher m = p.matcher(example);

while (m.find()) {
    Log.i("Findings", "values are " + m.group());
}