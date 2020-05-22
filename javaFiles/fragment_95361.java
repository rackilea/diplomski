private static void fixComponentWidths(Component container,
    List<? extends Component> componentList, int componentHeight) {

    if (!componentList.isEmpty()) { // Avoid possible division by zero

        // get the desired component width for the container using integer division
        int baseComponentWidth = container.getWidth() / componentList.size();

        // find the remainder
        int remainder = container.getWidth() % componentList.size();

        // update all the components
        for (int i = 0; i < componentList.size(); i++) {

            // the component width will be the base width plus 1 iff i < remainder
            int componentWidth = baseComponentWidth;
            if (i < remainder) {
                componentWidth++;
            }

            // update the maximum size
            componentList.get(i).setMaximumSize(new Dimension(componentWidth, componentHeight));
        }

        // be sure to revalidate otherwise it may not work
        container.revalidate();
    }
}