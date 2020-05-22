//that's how I canged my group data
List newGroups = new ArrayList();

for(int i = 0; i < groups.size(); ++i)
{
    String savedGroupName = (String) ((HashMap) groups.get(i)).get(groupName);
    HashMap groupContent = new HashMap();
    groupContent.put(groupName, savedGroupName);
    groupContent.put(groupRate, getString(R.string.newstring));
    newGroups.add(groupContent);
}

//but instead of using  
groups = newGroups;

//I had this:
groups.set(somePosition, newGroups);