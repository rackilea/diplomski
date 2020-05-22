private IModel<String> ldcClassModel;

public Hello() {
    super();

    ldcClassModel = Model.of("default");
    final WebMarkupContainer ldc = new WebMarkupContainer("linkDecisionContainer");
    add(ldc);
    ldc.setOutputMarkupId(true);
    ldc.add(new AttributeModifier("class", ldcClassModel));

    AjaxLink left = new AjaxLink("leftChoice") {
        private static final long serialVersionUID = 1L;

        @Override
        public void onClick(AjaxRequestTarget target) {
            ldcClassModel.setObject("left");
            target.addComponent(ldc);
        }
    };
    AjaxLink right = new AjaxLink("rightChoice") {
        private static final long serialVersionUID = 1L;

        @Override
        public void onClick(AjaxRequestTarget target) {
            ldcClassModel.setObject("right");
            target.addComponent(ldc);
        }
    };

    add(left);
    add(right);

}