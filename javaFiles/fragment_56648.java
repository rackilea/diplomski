String result;
try {
    String str = null;
    TurkishMorphParser parser = TurkishMorphParser.createWithDefaults();
    str = new Stm(parser).parse(word);
    //System.out.println("str = " + str);
    String replace = str.replace("[","");
    String replace1 = replace.replace("]","");
    List<String> result1 = new ArrayList<String>(Arrays.asList(replace1.split(",")));
    result = result1.get(0).toString();
    //System.out.println("Result = " + result);

 } catch(NullPointerException ex) {
   // do nothing
}
    return result;