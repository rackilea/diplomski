MatchOperation match = Aggregation.match(Criteria.where("hourNumber").is(21).and("errorSegments.agentName").is("agentX"));
ProjectionOperation project = Aggregation.
            project().and(ArrayOperators.Filter.filter("errorSegments")
                    .as("e")
                    .by(ComparisonOperators.Eq.valueOf(
                            "e.agentName")
                            .equalToValue(
                                    "agentX")))
                    .as("errorSegments");
UnwindOperation unwind = Aggregation.unwind("errorSegments");
ReplaceRootOperation replaceRoot = Aggregation.replaceRoot("errorSegments");
Aggregation aggregation = Aggregation.newAggregation(match,project,unwind,replaceRoot);