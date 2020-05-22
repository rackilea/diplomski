Query query = new Query();
query.addCriteria(
        new Criteria().andOperator(

        Criteria.where("listOfFiles.$id").is(new ObjectId(file.getId()))
        )

);

return  mongoTemplate.findOne(query,Directory.class);