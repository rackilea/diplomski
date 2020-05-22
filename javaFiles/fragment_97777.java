String assigneeText = assertion.getText();
boolean nameFound = false;
for(String name: names)
{
    nameFound = assigneeText.contains(name);

    if(nameFound)
    {
        break;
    }
}

assertTrue(nameFound, "None of the expected names were found in the following assignee text: " + assigneeText);