final String ps =
        "(?i)[-a-z0-9+_][-a-z0-9+_.]*@[-a-z0-9][-a-z0-9.]*\\.[a-z]{2,6}";
final Pattern p = Pattern.compile(ps);
for (String s : new String[] {"foo@bar.COM", "+foo@bar.COM",
        "-foo@bar.COM", "fo_o@bar.COM", "f.oo@bar.COM", "a@b.cdefgh",
        "3@4.com", "3@4.5.6-7.8.com", ".foo@bar.com", "a@b.cdefghi",
        "闪闪发光@闪闪发光.com"})
{
    final Matcher m = p.matcher(s);
    if (m.matches()) {
        System.out.println("Success: " + s);
    } else {
        System.out.println("Fail: " + s);
    }
}