Bson count = new Document("statuses", Document.parse("{$size:{\n" +
            "            $filter: {\n" +
            "               input: \"$statuses\",\n" +
            "               as: \"status\",\n" +
            "               cond: { \"$or\" : [ {$gt:[\"$$status.statusA\", 0]} , {$gt:[\"$$status.statusB\", 0]}]}\n" +
            "            }\n" +
            "         }}"));
Bson project = new Document("$project", count);
col.aggregate(Arrays.asList(project));