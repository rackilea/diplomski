MetricCollection metricCollection = metricDefinition.defineQuery()
                        .startingFrom(recordDateTime.minusDays(7))
                        .endsBefore(recordDateTime)
                        .withAggregation("Average")
                        .withInterval(Period.minutes(5))
                        .withOdataFilter("apiName eq 'PutBlob' and responseType eq 'Success' and geoType eq 'Primary'")
                        .execute();