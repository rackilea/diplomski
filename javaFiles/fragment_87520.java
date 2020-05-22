String[] str = new String[]{"<TD><P>xyz...  </P><P>Oiuye </P><P>Oture, </P><P>Option</P></TD><TD><P> EUR 0.20 </P></TD><Span></Span> ", "<TD><P>Foriegn </P></TD><TD><P> EUR 0.30 </P></TD><Span></Span>"};
    Pattern p = Pattern.compile("\\</TD\\>\\<TD\\>\\<P\\>(.*?)\\</P\\>");
    for (String st : str) {
        Matcher m = p.matcher(st);
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }