String s = "load_id,policy_id,policy_number";
Pattern p = Pattern.compile( "_([a-zA-Z])" );
Matcher m = p.matcher( s );
StringBuffer sb = new StringBuffer();
while (m.find()) {
    m.appendReplacement(sb, m.group(1).toUpperCase());
}
m.appendTail(sb);
System.out.println(sb.toString()); // loadId,policyId,policyNumber