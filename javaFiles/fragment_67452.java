private Date dateTime; // Original field
private Long dateTimeMillis;

@Column(name = "datetime")
@NotNull
@Convert(converter = DateConverter.class)
public Date getDateTime() {
    return dateTime;
}

// Another mapping for the datetime column, will use this for criteria queries:
@Column(name = "datetime", updatable = false, insertable = false)
public Long getDateTimeMillis() {
    return dateTimeMillis;
}