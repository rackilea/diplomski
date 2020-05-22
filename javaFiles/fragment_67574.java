Component[] components = this.getComponents();
List<Component> buttons = new ArrayList<Component>();

for (Component component : components)
{
    if (component instanceof JButton)
    {
        buttons.add(component);
    }
}