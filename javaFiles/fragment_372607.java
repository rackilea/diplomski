public class Incident {
    @SerializedName("_id")
    private String _id;
    private String docNo;
    private String site_id;
    private String company;
    private String division;
    private String department_id;
    private CustomDateHolder dateReported;
    private String briefDescription;
    private String thirdPartyInvolvedYN;
    private String supervisor;
    private String classification;
    private String status;
    private String injuredPerson;
    private String reportingPerson;
    private CustomDateHolder occurDate;
    private String occurTime;
    // Getters & Setters...
}