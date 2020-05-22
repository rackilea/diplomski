String str = "Test-docID-02";
final String regex = "^(.*-)(\\d{2})$";
final Pattern p = Pattern.compile(regex);

Matcher m = p.matcher(str);

if (m.matches()) {
    str = m.group(1) + String.format("%02d", Integer.parseInt(m.group(2)) + 1);
} else {
    str += "-01";
}

//=> Test-docID-03