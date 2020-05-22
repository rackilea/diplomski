@XmlRootElement(name = "DocumentToHide", namespace = "http://service.myservice.com")
@XmlAccessorType(XmlAccessType.FIELD)
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class FileInfo implements Serializable {

  private static final long serialVersionUID = -4652784599316765768L;

  private String documentID;

  private String fileNetGUID;

  private String comments;

  public String getDocumentID() {
      return documentID;
  }

  public void setDocumentID(String documentID) {
      this.documentID = documentID;
  }

  public String getFileNetGUID() {
      return fileNetGUID;
  }

  public void setFileNetGUID(String fileNetGUID) {
      this.fileNetGUID = fileNetGUID;
  }

  public String getComments() {
      return comments;
  }

  public void setComments(String comments) {
      this.comments = comments;
  }

}