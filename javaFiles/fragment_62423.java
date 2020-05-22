String allPagesAsString = "";

for(int i=0;i<allPages.size();i++)
{
    allPagesAsString = allPagesAsString+
       fileHelper.turnListToString(allPages.get(i));
}