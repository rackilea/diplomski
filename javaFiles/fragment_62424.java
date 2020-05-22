int expectedBookSize = 10000;
StringBuilder allPagesAsString = new StringBuilder(expectedBookSize); 
for(int i=0;i<allPages.size();i++)
{
        allPagesAsString.append(fileHelper.turnListToString(allPages.get(i)));
}