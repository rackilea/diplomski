Aggregation aggregation = newAggregation(
       project(from(field("dayActivity.type", "dayActivity.type"), 
                    field("tid"))).
               and("activityDate").dateAsFormattedString("%Y-%m-%d").as("yearMonthDay"),
       match(where("yearMonthDay").is("2017-11-05").and("tid").is("12345678"))
);