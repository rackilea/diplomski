private String downloadKey; // +Getter.

public void prepareDownload() {
    FacesContext context = FacesContext.getCurrentInstance();

    if (canDownload) {
        downloadKey = UUID.randomUUID.toString();
        context.getExternalContext().getSessionMap().put(downloadKey, certificadoModel);
        context.addMessage(null, infoMessage);
    } else {
        context.addMessage(null, errorMessage);
    }
}