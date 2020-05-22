makes.add(new AjaxFormComponentUpdatingBehavior("change")
    {
        @Override
        protected void onUpdate(AjaxRequestTarget target)
        {
            models.setEnabled(makes.getModelObject() != null);
            target.add(models);
        }
    });