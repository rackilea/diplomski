final int nbElems = 5;
List<String> test = new ArrayList<String>(Arrays.asList("a,b,c,d,e,f,g,h,i,j".split(",")));

StringBuilder sb = null;
for (int i=0; i<test.size(); i++) {
    if (i%nbElems==0)
        sb = new StringBuilder("\"");
    else
        sb.append("\" OR \"");
    sb.append(test.get(i));
    if (i%nbElems==(nbElems-1) || i==(test.size()-1)) {
        sb.append("\"");
        final String result = sb.toString();
        System.out.println(result); // TODO: do something
    }
}