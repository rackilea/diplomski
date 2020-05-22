String pre = "ORDER WILL SHIP ";
String suf = " WORKING DAYS";
String output = testSequence.substring(testSequence.indexOf(pre) + pre.length(), testSequence.indexOf(suf));
if(output.startsWith("_")&&output.endsWith("_")){
    output = output.substring(1, output.length()-1);
}
int num = Integer.parseInt(output);