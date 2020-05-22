public void addToList()
{
    String inputName = Dialog.request("Please Enter A Name");
    while(!inputName.equalsIgnoreCase(""))
    {
        aList.add(inputName);
        inputName = Dialog.request("Please Enter A Name");
    }
}