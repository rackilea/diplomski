@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setCurrentDateRequest", propOrder = {
    "date"
})
public class SetCurrentDateRequest {

    @XmlSchemaType(name="date")
    protected Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}