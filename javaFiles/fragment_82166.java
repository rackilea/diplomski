public void getLatestReport() throws Exception {


    try {
        if (getWorkbookForLatestBytes() != null) {

            Faces.sendFile(getWorkbookForLatestBytes(), reportName, true);

        }
    } catch (Exception e) {
        throw e;
    }
}