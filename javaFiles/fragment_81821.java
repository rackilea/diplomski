Action action = new AbstractAction()
{
    public void actionPerformed(ActionEvent e)
    {
        menu = new JPopupMenu();
        menu.add("item1");
        menu.add("item2");
        Component component = (Component)e.getSource();
        menu.show(component, component.getX(), component.getY());
    }
};
String keyStrokeAndKey = "ESCAPE";
KeyStroke keyStroke = KeyStroke.getKeyStroke(keyStrokeAndKey);
txt.getInputMap().put(keyStroke, keyStrokeAndKey);
txt.getActionMap().put(keyStrokeAndKey, action);