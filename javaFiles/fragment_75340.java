db.collection.aggregate([ 
    { "$sort": { "value": -1 } },
    {
        "$group": {
            "_id": null,
            "largestValue": { "$first": "$value" },
            "date": { "$first": "$dateTime" }
        }
    }
])