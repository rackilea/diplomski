public MyClass() {
    muplDefPdf = new MultiUploader();
    setMuplDef(muplDefPdf, "pdf", onFinishUploaderHandlerPdf,
            onCancelUploaderHanderPdf);
    muplDefJpg = new MultiUploader();
    setMuplDef(muplDefJpg, "jpg", onFinishUploaderHandlerJpg,
            onCancelUploaderHanderJpg);
    initWidget(uiBinder.createAndBindUi(this));
}