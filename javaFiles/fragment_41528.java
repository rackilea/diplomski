public class ComboWithIcon extends Panel {
    public ComboWithIcon() {
        // basic item configuration
        ComboBox comboBox = new ComboBox();
        comboBox.addStyleName(ValoTheme.COMBOBOX_BORDERLESS);

        Button searchButton = new Button();
        searchButton.setIcon(VaadinIcons.SEARCH);
        searchButton.addStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        searchButton.addStyleName("no-focus"); // remove the annoying focus effect
        searchButton.addClickListener(event -> {/* add button listener here */ });

        // add components to the layout - switch these to have the button to the left of the combo
        CssLayout layout = new CssLayout(searchButton, comboBox);
        // set group style
        layout.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        setContent(layout);
        setWidthUndefined(); // fit the component widths instead of expanding by default
    }
}