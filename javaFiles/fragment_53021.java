class Pojo {
    long startTime;
    long endTime;
    @JsonDeserialize(using = MongoDateConverter.class)
    Date startDate;
    @JsonDeserialize(using = MongoDateConverter.class)
    Date endDate;
}