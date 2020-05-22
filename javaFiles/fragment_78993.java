db.collection.update(
    { "bssid": "ca:fe:de:ad:be:ef" },
    {
        "$setOnInsert": { "channel": 6 },
        "$push": {
            "heardpoints": {
                "$each": [{
                    "geometry": {
                        "type": "Point",
                        "coordinates": [-75.234564, 36.12345 ]
                    },
                    "time": ISODate("2014-11-04T21:09:18.437Z")
                }],
                "$sort": { "time": -1 },
                "$slice": 20
            }
        }
    },
    { "upsert": true }
);