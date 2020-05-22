db.collection.update(
    { 
        "bssid": "ca:fe:de:ad:be:ef",
         "geometry": {
             "type": "Point",
             "coordinates":  [-75.234564, 36.12345 ]
         }
    },
    { 
        "$setOnInsert": { "channel": 6 },
        "$set": { "time": ISODate("2014-11-04T21:10:28.919Z") }
    }
    { "upsert": true }
)