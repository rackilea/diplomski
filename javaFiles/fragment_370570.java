@ManagedBean
public class DownloadBean {

/**
 * Creates a new instance of DownloadBean
 */

private DefaultStreamedContent download;

public void setDownload(DefaultStreamedContent download) {
    this.download = download;
}

public DefaultStreamedContent getDownload() throws Exception {
    System.out.println("The file: " + download.getName());
    return download;
}

public void prepareDownload() throws Exception {
    File file = new File("C://ImagenesAlmacen/Reporte/report.pdf");
    InputStream input = new FileInputStream(file);
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    setDownload(new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName()));
}

}