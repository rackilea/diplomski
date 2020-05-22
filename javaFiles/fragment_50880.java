items.map(row => {
      val mongo_id = new ObjectId(row("id").toString)
      val query = new BasicBSONObject()
      query.append("_id", mongo_id)
      val update = new BasicBSONObject()

      update.append("$set", new BasicBSONObject().append("field_name", row("new_value")))
      val muw = new MongoUpdateWritable(query,update,false,true)
      (null, muw)
    })
     .saveAsNewAPIHadoopFile(
       "file:///bogus",
       classOf[Any],
       classOf[Any],
       classOf[com.mongodb.hadoop.MongoOutputFormat[Any, Any]],
       mongo_config
     )