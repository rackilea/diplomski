private DateTime createdOn;
...
public Builder createdOn(final DateTime createdOn) {
    this.createdOn = createdOn;
    return this;
}

public Builder createdOn(final String createdOn) {
    this.createdOn = DateTime.parse(createdOn, dateTimeFormatter);
    return this;
}

public Builder createdOn(final Date createdOn) {
    this.createdOn = new DateTime(createdOn);
    return this;
}