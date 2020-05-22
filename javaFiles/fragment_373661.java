appString = new String[app.size()][];
for(int i = 0; i<app.size();i++)
{
    Vector appVec = (Vector) app.get(i);
    String[] s = new String[appVec.size()];
    appVec.toArray(s);
    appString[i] = s;
}