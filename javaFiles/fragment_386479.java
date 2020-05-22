Date fromDate = LocalDate.parse("2017-03-12").toDate();
Date toDate = LocalDate.parse("2017-03-13").toDate();

BasicDBObject("$match",
            new BasicDBObject("date",
                    new BasicDBObject("$gte",fromDate).
                                  append("$lt",toDate)
                             )
          );