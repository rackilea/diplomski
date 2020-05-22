Aggregation agg = newAggregation(
            group("title").
            push(new BasicDBObject
                   ("version", "$version").append
                   ("author", "$author").append
                   ("dateAdded", "$dateAdded")).as("versions"));