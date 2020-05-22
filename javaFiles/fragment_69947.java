public class ArchiveJobHeaderComponents implements Serializable {

  private String jobId;
  private int type; // int should give you a large enough range - but change to long if required
  private String componentDescription;
  private String componentId;
  private boolean status; // status appears to be a boolean (NUMBER(1))
  private String reason;
  private String notes;
  // remainder omitted
}