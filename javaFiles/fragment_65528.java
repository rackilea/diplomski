private void addPreservePrecisionBehavior(final TextField<BigDecimal> field) {
    field.add(new AjaxFormComponentUpdatingBehavior("onclick") {
        @Override
        protected void onUpdate(AjaxRequestTarget target) {
            String js = String.format("copyExactValueFromTitle('%s')", field.getMarkupId());
            target.appendJavascript(js);
        }
    });
}