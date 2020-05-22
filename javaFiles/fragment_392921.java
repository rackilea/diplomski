fileUpload.add(new AjaxEventBehavior("onChange") {

    @Override
    protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
    {
        super.updateAjaxAttributes(attributes);

        String value = "return {'value': Wicket.$(attrs.c).value}";
        attributes.getDynamicExtraParameters().add(value);
    }

    @Override
    protected void onEvent(AjaxRequestTarget target) {
        Request request = RequestCycle.get().getRequest();

        request.getRequestParameters().getParameterValue("value");

    }

});