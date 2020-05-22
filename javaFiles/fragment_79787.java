db.collection.find().forEach(function(doc){
    db.collection.update(
        {"_id":doc._id},
        {
            "$set":{
                "GPS":[doc.longitude, doc.latitude]
            },
            "$unset" : {longitude : "", latitude : ""}
        }
    );
})