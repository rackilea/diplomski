MongoOperations mongoOperations; //inject
    Query query = new Query();

    Update update=new Update();

    update.set("quantity", materialRequest.getQuantity());
    update.set("usrId", materialRequest..getUsrId());
    query.addCriteria(Criteria.where("ticketId").is(materialRequest.getTicketId()).and("materialId").is(materialRequest.getMaterialId()));

   long count = mongoOperations.count(query, MaterialRequest.class);

   if (count <= 0)
   {

    mongoOperations.save(materialRequestList,     MongoCollections.MATERIAL_REQUEST_COLLECTION);

    } else
   {

   mongoOperations.updateFirst(query, update, MaterialRequest.class);

   }