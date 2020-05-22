class MongoDate {
    @JsonProperty("$date")
    Date date;
}

class Pojo {
    long startTime;
    long endTime;
    MongoDate startDate;
    MongoDate endDate;
}