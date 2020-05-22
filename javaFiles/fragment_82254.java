public class EmailListBean {
    @RecipientList
    public String[] emails() {
        return new String[] {"smtp://joe@host:port?options",
                "smtp://fred@host:port?options"};
    }
}

.useOriginalMessage()
.to(deadLetterQueueA)
.transform().simple("...")
.bean(EmailListBean.class)