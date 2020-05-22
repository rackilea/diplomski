@Override
protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
        String renderedResponse = null;
        if (model instanceof SoyDataModel) {
            renderedResponse = compiledSoyTemplates.render(
                templateName,
                (SoyDataModel)model,
                messageBundle
            );
        }
        else {
            renderedResponse = compiledSoyTemplates.render(
                templateName,
                model,
                messageBundle
            );
        }
}