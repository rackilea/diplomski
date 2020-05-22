public class Feature implements Serializable {
private String dueDate;
@JsonDeserialize(using = DateAdaptor.class)
public Date getDueDate() {
    return due_date;
}
@JsonProperty("due_date")
public void setDueDate(Date dueDate) {
    this.due_date = dueDate;
}