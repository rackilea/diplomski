db.collection.update(
    { "bssid": "ca:fe:de:ad:be:ef" },
    {
        "$setOnInsert": { "channel": 6 },
        "$addToSet": {
            "heardpoints": {
                "$each": [{
                    "geometry": {
                        "type": "Point",
                        "coordinates": [-75.234564, 36.12345 ]
                    }
                }]
            }
        }
    },
    { "upsert": true }
);