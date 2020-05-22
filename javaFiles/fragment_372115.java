private Date msgDate;
@Column(name = "msgDate", columnDefinition="timestamp")
public Date getMsgDate() {
   return this.msgDate;
}

public void setMsgDate(Date msgDate) {
    this.msgDate = msgDate;
}

public Date getMsgDateFormatted() {
    SimpleDateFormat df = new SimpleDateFormat("yyyy MM dd HH mm ss");
    return df.format(msgDate);
}