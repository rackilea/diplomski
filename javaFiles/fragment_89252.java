public static void main(String[] args) throws Exception {
    String s = "PING 151.92.198.78 (151.92.198.78) 56(84) bytes of data." + "\n"
            + "From 10.251.211.1: icmp_seq=1 Time to live exceeded";

    Pattern p = Pattern.compile(".*From\\s+(.*?):\\s+icmp_seq", Pattern.DOTALL);
     // pattern selects everything preceeded by "From" upto ":<space>icmp_seq"
    Matcher m = p.matcher(s);
    while(m.find()) {
        System.out.println(m.group(1));
    }

}