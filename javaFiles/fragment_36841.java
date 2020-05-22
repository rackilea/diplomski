void modifySwingComponents()
{
    if (SwingUtilities.isEventDispatchThread())
    {
        // We're on the right thread - direcly call the method
        modifySwingComponentsOnEDT();
    }
    else
    {
        // Put the task to execute the method in the event queue,
        // so that it will be executed on the EDT as soon as possible
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                modifySwingComponentsOnEDT();
            }
        });
    }
}

// Always called on the EDT!
void modifySwingComponentsOnEDT()
{
    someComponent.add(someOtherComponent);
    someComponent.remove(somethingElse);
    someTextComponent.setText("Text");
    ...
}