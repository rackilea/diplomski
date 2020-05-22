public class AddUserInput extends VerticalLayout {

    private HorizontalLayout content = new HorizontalLayout();;
    private NativeSelect<String> select = new NativeSelect<>("The List");
    private ListDataProvider<String> dataProvider = DataProvider.ofCollection(new ArrayList<>());
    private Button addToListButton= new Button("Add to list");
    private Button deleteFromListButton = new Button("-");
    private TextField emailField = new TextField("Enter email address");

    public AddUserInput() {
        select.setVisibleItemCount(5);
        select.setWidth("100px");
        select.setDataProvider(dataProvider);
        select.setEmptySelectionAllowed(false);
        deleteFromListButton.setEnabled(false);
        content.setMargin(true);
        addToListButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                addEmailToList(emailField.getValue());
            }
        });
        deleteFromListButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                select.getSelectedItem().ifPresent(selectedItem -> removeSelectedEmailFromList());

            }
        });
        select.addValueChangeListener(new HasValue.ValueChangeListener<String>() {
            @Override
            public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent) {
                deleteFromListButton.setEnabled(select.getSelectedItem().isPresent());
            }
        });

        content.addComponents(emailField, addToListButton, select, deleteFromListButton);

        addComponent(content);
    }

    private void addEmailToList(String email){
        dataProvider.getItems().add(email);
        select.getDataProvider().refreshAll();
        emailField.clear();
    }

    private void removeSelectedEmailFromList(){
        select.getSelectedItem().ifPresent(selectedItem -> dataProvider.getItems().remove(selectedItem));
        select.setSelectedItem(dataProvider.getItems().isEmpty() ? null : dataProvider.getItems().iterator().next());
        select.getDataProvider().refreshAll();
    }

}