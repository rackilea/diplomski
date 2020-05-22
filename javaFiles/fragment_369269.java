@XmlRootElement(name = "FooDTO")
public class Foo {

    @XmlElement(nillable = true)
    private String approvedDate;
    private static final DateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");


    public String getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate == null ? "" : DEFAULT_DATE_FORMAT
                .format(approvedDate);
    }
}