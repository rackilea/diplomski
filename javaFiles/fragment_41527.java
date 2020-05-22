public class ComboWithIcon extends CssLayout {
    public ComboWithIcon() {
        // basic item configuration
        ComboBox comboBox = new ComboBox();

        Button searchButton = new Button();
        searchButton.setIcon(VaadinIcons.SEARCH);
        searchButton.addStyleName(ValoTheme.BUTTON_FRIENDLY); // remove this to have a regular button
        searchButton.addClickListener(event -> {/* add button listener here */ });

        // add components to the layout - switch these to have the button to the left of the combo
        addComponent(comboBox);
        addComponent(searchButton);

        // set group style
        addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
    }
}