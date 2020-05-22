String text = "Duration: 00:05:25.00, start: 0.000000, bitrate: 554 kb/s";
final Pattern p = Pattern.compile(".?bitrate:\\s([0-9]*)\\skb/s");
final Matcher m = p.matcher(text);
if(m.find())
{
    System.out.println(m.group(1));
}