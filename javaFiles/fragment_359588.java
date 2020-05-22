JPanel container = new JPanel(new GridBagLayout());
    //...
    List<Component> components = new ArrayList<>();
    // Add components to container and to list...
    for (Component c : components) {
        container.remove(c);
    }
    container.revalidate();
    container.repaint();