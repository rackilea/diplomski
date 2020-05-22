ArrayList<MailItem> l = mailMap.get(who);
if(l == null){ // this super verbose code will simplify with the Guava MultiMap
  l = new ArrayList<MailItem>();
  mailMap.put(who, l);
}
l.add(/* code to create a new MailItem */);