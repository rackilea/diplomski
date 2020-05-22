collection.aggregate(Arrays.asList(
        Aggregates.match(Filters.eq("username", username)),
        Aggregates.unwind("$questionAnswer"),
        Aggregates.project(Projections.fields(Projections.excludeId(), 
                Projections.computed("idQuestion", "$questionAnswer.idQuestion"), 
                Projections.computed("idAnswer", "$questionAnswer.idAnswer")
        ))
)).forEach(doWhateverYouNeed);