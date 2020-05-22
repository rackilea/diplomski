@Theme("mytheme")
public class MyVaadinUI extends UI {

    private Field firstName, email;
    private FormLayout form;

    @Override
    public void init(VaadinRequest request){
        VerticalLayout layout = new VerticalLayout();

        //1. set a propertyitem for the fieldgroup
        final BeanFieldGroup<Person> binder = new BeanFieldGroup<Person>(Person.class);
        binder.setItemDataSource(new BeanItem<Person>(new Person()));
        form = new FormLayout();


        //2. don't use field Field, it's useless
        firstName = binder.buildAndBind("Firstname", "firstName");
        email = binder.buildAndBind("Email", "email");

        form.addComponent(firstName);
        form.addComponent(email);

        layout.addComponent(form);

        //3. add a button to submit the form
        form.addComponent(new Button("OK", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                try {
                    binder.commit();
                    Notification.show("Thanks!");
                } catch (FieldGroup.CommitException e) {
                    Notification.show("You fail!");
                }
            }
        }));
        setContent(layout);
    }
}