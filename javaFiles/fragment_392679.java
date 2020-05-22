try {
        //mongoCollection.update("{_id : #}", new org.bson.types.ObjectId(id)).with("{$set: {nome: #}}", nome);
        System.out.println(mongoCollection.findOne("{_id : #}", new org.bson.types.ObjectId(id)).as(BasicDBObject.class));
        mongoCollection.withWriteConcern(WriteConcern.SAFE).findAndModify(
               "{_id : #}", new org.bson.types.ObjectId(id)).returnNew().with(
               "{$set : {'nome' : #}}", nome).as(BasicDBObject.class);

    }catch(Exception e){
        e.printStackTrace();
    }