treeUtils.setIgnoreLexicographicOrder(true);
List<TreeEvent> events = treeUtils.getSubtree(getTarget(), tableOid);
if (events == null || events.size() == 0)
{
    System.out.println("Error: Unable to read table...");
    return;
}
 .
 .
 .
if( binds == null)
{
    binds = new ArrayList<VariableBinding>();
    binds.add(varBinding);
    resultMap.put(oid.toString(), binds); 
}