public interface DoActionThing
{
    public void doSomething();
}

public class Sample
{
    private final String LIST_ITEM_1 = "Foo";
    private final String LIST_ITEM_2 = "Bar";

    private Map<String, DoActionThing> actions;

    public Sample()
    {
        actions = new HashMap<String, DoActionThing>();
        actions.put(LIST_ITEM_1, new DoActionThing()
        {
            @Override
            public void doSomething()
            {
                handleFooSelection();
            }
        });
        actions.put(LIST_ITEM_2,  new DoActionThing()
        {
            @Override
            public void doSomething()
            {
                handleBarSelection();
            }
        });
    }

    public void onListItemClick()
    {
    //Get the selected string from list
        String selected = ....
        DoActionThing dat = actions.get(selected);
        dat.doSomething();
    }
}