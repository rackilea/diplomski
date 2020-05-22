public static class MyOwnFocusTraversalPolicy extends FocusTraversalPolicy
{
    Vector<Component> order;

    public MyOwnFocusTraversalPolicy(Vector<Component> order)
    {
        this.order = new Vector<Component>(order.size());
        this.order.addAll(order);
    }

    public Component getComponentAfter(Container focusCycleRoot,
                                       Component aComponent)
    {
//      int idx = (order.indexOf(aComponent) + 1) % order.size();
//      return order.get(idx);

        int idx = order.indexOf(aComponent);

        for (int i = 0; i < order.size(); i++)
        {
            idx = (idx + 1) % order.size();
            Component next = order.get(idx);

            if (canBeFocusOwner(next)) return next;
        }

        return null;
    }

    public Component getComponentBefore(Container focusCycleRoot,
                                        Component aComponent)
    {
/*
        int idx = order.indexOf(aComponent) - 1;
        if (idx < 0) {
            idx = order.size() - 1;
        }
        return order.get(idx);
*/
        int idx = order.indexOf(aComponent);

        for (int i = 0; i < order.size(); i++)
        {
            idx = (idx - 1);

            if (idx < 0)
            {
                idx = order.size() - 1;
            }

            Component previous = order.get(idx);

            if (canBeFocusOwner(previous)) return previous;
        }

        return null;
    }

    public Component getDefaultComponent(Container focusCycleRoot) {
//      return order.get(0);
        return getFirstComponent( focusCycleRoot );
    }

    public Component getLastComponent(Container focusCycleRoot) {
//      return order.lastElement();

        Component c = order.lastElement();

        if (canBeFocusOwner(c))
            return c;
        else
            return getComponentBefore(focusCycleRoot, c);
    }

    public Component getFirstComponent(Container focusCycleRoot)
    {
//      return order.get(0);

        Component c = order.get(0);

        if (canBeFocusOwner(c))
            return c;
        else
            return getComponentAfter(focusCycleRoot, c);
    }

    private boolean canBeFocusOwner(Component c)
    {
        if (c.isEnabled() && c.isDisplayable() && c.isVisible() && c.isFocusable())
        {
            return true;
        }

        return false;
    }

}