protected void populateItem(ListItem<Data> item)
    {
        Data data = item.getModelObject();
        final Serializable id = data.getId(); // the primary key
        AjaxSubmitLink delete = new AjaxSubmitLink("delete")
        {
            protected void onSubmit(AjaxRequestTarget target, Form<?> form)
            {
                DB.delete(id);
                target.add(form);
            }
        }
    }