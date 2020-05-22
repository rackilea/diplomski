add(new ListView<User>("headerList", new PropertyModel<>(this, "users")) {
    @Override
    protected void populateItem(ListItem<User> listItem) {
        listItem.add(new Label("name", new PropertyModel(listItem.getModelObject(), "name")));
    }
});

add(new ListView<String>("rowList", new PropertyModel<>(this, "roles")) {

    @Override
    protected void populateItem(ListItem<String> listItem) {
        final String role = listItem.getModelObject();

        listItem.add(new Label("name", role));

        listItem.add(new ListView<User>("cellList", new PropertyModel<>(TestPage.this, "users")) {

            @Override
            protected void populateItem(ListItem<User> listItem) {
                final User user = listItem.getModelObject();

                listItem.add(new AjaxCheckBox("checkbox", new IModel<Boolean>() {

                    @Override
                    public Boolean getObject() {
                        return user.getRoles().contains(role);
                    }

                    @Override
                    public void setObject(Boolean aBoolean) {
                        if (aBoolean) {
                            user.getRoles().add(role);
                        } else {
                            user.getRoles().remove(role);
                        }
                    }

                    @Override
                    public void detach() {

                    }
                }) {

                    @Override
                    protected void onUpdate(AjaxRequestTarget ajaxRequestTarget) {

                    }
                });
            }
        });
    }
});