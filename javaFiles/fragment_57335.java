@Command
public void setupQuicksearchByEvent(@BindingParam("searchlayout")Event event, @BindingParam("prefix") String prefix, @BindingParam("tags") String tags) throws WrongValueException, SearchException, IOException
{
    if(event instanceof InputEvent)
    {
        InputEvent inputEvent = (InputEvent) event;
        String inputText = inputEvent.getValue();

        List<String> searchFields = Arrays.asList(tags.split(","));
        Map<UID, String> publishers = ZKLogic.findDocsStartingWith(prefix, searchFields, "proxy", inputText);

        Combobox searchBox = (Combobox) event.getTarget();
        searchBox.getChildren().clear();

        for (Map.Entry<UID, String > entry : publishers.entrySet())
        {
            Comboitem item = new Comboitem();
            item.setLabel(entry.getValue());
            item.setValue(entry.getKey());
            searchBox.appendChild(item);
        }
    }
}