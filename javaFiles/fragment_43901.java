public void unfriend(String name)
{
    String[] parseNames = friendNames.split(name);
    friendNames = parseNames[0] + parseNames[1];
    friendCount--;
}