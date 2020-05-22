Iterator<Map.Entry<String, ArrayList<MailItem>>> it = mailMap.entrySet().iterator();
while(it.hasNext()) {
  Map.Entry<String, ArrayList<MailItem>> entry = it.next();
  String key = entry.getKey();
  ArrayList<MailItem> value = entry.getValue();
  if (key.equals(who)); // the semicolon here means that if the condition is true, do nothing
  {
    return value.remove(0); // this block is ALWAYS EXECUTED
  }
}
return null;