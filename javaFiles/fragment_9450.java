@ApiModel(value = "EMail", description = "Model with property for sending email")
@Document(collection = "email")
public class EMail extends Letter {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
    @ApiModelProperty(value = "Date send email")
    private Date sendEmail;

    public Date getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(Date sendEmail) {
        this.sendEmail = sendEmail;
    }
}