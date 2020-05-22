private void useList()
{
    String temp = getList().get(0); // access "via accessor" ----------+
    System.out.println(temp);                                          |
}                                                                      |
                                                                       |
public ArrayList<String> getList()                                     |
{                                                                      |
    return theList; // but you actually directly access it here...  <--+
}