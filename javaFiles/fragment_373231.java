if (displayAll.first())
{
    do
    {
        int typeId = displayAll.getInt(1);
        String description = displayAll.getString(2);
        String name = displayAll.getString(3);

        System.out.println(typeId + " " + description + " " + name);
    } while(displayAll.next());
}
displayAll.close();
listDisplay.close();