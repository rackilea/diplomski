db.getCollection('dayOfYear').aggregate([
    // ignore any documents which do not match dayOfYear=275
    { "$redact": {
        "$cond": {
             if: { $eq: [ { $dayOfYear: "$TIMESTAMP" }, 275 ] },
             "then": "$$KEEP",
             "else": "$$PRUNE"
        }
    }},

    // sum the count attribute for the selected day
    { $group : { _id : { name: "$name" }, total: { $sum: "$count" } } } 

])