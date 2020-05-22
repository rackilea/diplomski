TypedAggregation<Student> studentAggregation = Aggregation.newAggregation(Student.class,
              Aggregation.group("firstName").
                 push(new BasicDBObject
                       ("_id", "$_id").append
                       ("firstName", "$firstName").append
                       ("lastName", "$lastName")).as("students"));