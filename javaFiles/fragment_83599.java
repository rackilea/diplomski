jv.addContainerListener( new ContainerAdapter()
{
    @Override
    public void componentAdded(ContainerEvent e)
    {
        scrollPane.getViewport().setViewPosition(p);
    }
});