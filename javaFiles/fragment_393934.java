private FeedbackPanel feedbackPanel() {
    final FeedbackPanel fb = new FeedbackPanel("feedbackPanel") {
        @Override
        protected void onConfigure() {
            super.onConfigure();
            setVisible(anyMessage());
        }
    };
    fb.add(new AjaxEventBehavior("click") {
        @Override
        protected void onEvent(AjaxRequestTarget target) {
          fb.setVisible(false);
          target.add(fb);
        }
    });
    fb.setOutputMarkupPlaceholderTag(true);
    return fb;
}