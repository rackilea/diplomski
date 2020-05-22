if (path.contains("file:"))
{
    myPath = path.substring(path.indexOf(":/") + 1);
    while (myPath.startsWith("//"))
        myPath = myPath.substring(1);
}