String str = "zenity --question --title \"Share File\" --text \"Do you want to share file?\"";
String quote_unquote[] = str.split("\"");
System.out.println("quote_unquote = " + Arrays.toString(quote_unquote));
List<String> l = new ArrayList<>();
for(int i =0; i < quote_unquote.length; i++) {
    if(i%2 ==0) {
        l.addAll(Arrays.asList(quote_unquote[i].split("[ ]+")));
    }else {
        l.add(quote_unquote[i]);
    }
}
String cmdarray[] = l.toArray(new String[l.size()]);
System.out.println("cmdarray = " + Arrays.toString(cmdarray));
Runtime.getRuntime().exec(cmdarray);