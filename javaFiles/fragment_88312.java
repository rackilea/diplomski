@Data
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class MessageWrapper {
    private String type;
    private String messageId;
    private String topicArn;
    @JsonDeserialize(using = NotificationDeserializer.class)
    private Notification message;
    private Date timestamp;
    private String signatureVersion;
    private String signature;
    private String signingCertURL;
    private String unsubscribeURL;
}

@Data
public class Notification {
    private String notificationType;
    @JsonDeserialize(using = MailDeserializer.class)
    private Mail mail;
}

@Data
public class Mail {
    private String messageId;
    private String source;
    private String sourceArn;
    private String sourceIp;
    private String sendingAccountId;
    private String[] destination;
}