db.MyCollection.aggregate([
    {
        "$match": {
            "_id": { "$in": ['A', 'B', 'C'] }
        }
    },
    { "$unwind": "$nested.field" },
    {
        "$group": {
            "_id": "$_id", 
            "maxVersion": { "$max": "$nested.field.version" }
        }
    }
])