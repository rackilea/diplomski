abstract class BaseSystem<T> implements ISystem
{
    protected List<T> _componentList = new ArrayList<T>();
}

class RenderSystem extends BaseSystem<IRenderable>
{
    void Update()
    {
        for (IRenderable r : _componentList)
            r.Render(); // this code is specific to the IRenderable components
    }

    @Override
    public boolean AddToSystem(Component c)
    {
        boolean succesfullyAdded = false;

        if (c instanceof IRenderable)
        {
            succesfullyAdded = true;
            _componentList.add((IRenderable) c);

        } else
            throw new RuntimeException("ERROR - " + c.Name() + " doesn't implement IRenderable interface!");

        return succesfullyAdded;

    }
}