...
IReportRunnable design = engine.openReportDesign(designInputStream);
IRunAndRenderTask task = engine.createRunAndRenderTask(design);
IRenderOption options = null;
switch (format) {
            case ReportFormats.HTML_REPORT:
                options = new HTMLRenderOption();
                options.setOutputFormat(HTMLRenderOption.HTML);
                options.setOutputStream(outputStream);
                options.setSupportedImageFormats("PNG");
                ((HTMLRenderOption) options).setEmbeddable(true);
                options.setImageHandler(new HTMLServerImageHandler() {
                    @Override
                    protected String handleImage(IImage image, Object context,
                            String prefix, boolean needMap) {
                        String embeddedImage = null;

                        //embeddedImage = convert image.getImageStream() to Base64 String

                        return "data:image/png;base64," + embeddedImage;
                    }
                });
                break;
                ...

if (options != null) {
    task.setRenderOption(options);                              
    task.run();
    task.close();
    engine.destroy();
}
...