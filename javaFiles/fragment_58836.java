// test string
String input = "! hostname ${hostname} ! ! ! ip name-server "
            + "${ip-name-server} no ipv6 cef ! ! "
            + "voice class codec 1 codec preference 1 ${codec-pref-1} "
            + "codec preference 2 ${codec-pref-2} codec preference 3 "
            + "${codec-pref-3} ! ! session target "
            + "dns:${session-targ-DNS} dtmf-relay rtp-nte";

// compiling pattern with one group representing the text inside ${}
Pattern p = Pattern.compile("\\$\\{(.+?)\\}");
// initializing matcher
Matcher m = p.matcher(input);
// iterating find
while (m.find()) {
    // back-referencing group 1 each find
    System.out.println(m.group(1));
}