...
Attribute sidHistory = roleAttributes.get("sIDHistory;binary");
List<String> sidHistoryStrings = new LinkedList<String>();
if (sidHistory != null) 
{
  NamingEnumeration<?> sidHistoryEnum = sidHistory.getAll();
  while (sidHistoryEnum.hasMore()) 
  {
    byte[] sidHistoryBytes = (byte[]) sidHistoryEnum.next();
    sidHistoryStrings.add(new Sid(sidHistoryBytes).toString());
  }
...
}