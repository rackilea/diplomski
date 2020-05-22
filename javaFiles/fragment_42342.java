db.getCollection('dayOfYear').aggregate([

    // project dayOfYear as an attribute
    { $project: { name: 1, count: 1, dayOfYear: { $dayOfYear: "$TIMESTAMP" } } },

    // match documents with dayOfYear=275
    { $match: { dayOfYear: 275 } },

    // sum the count attribute for the selected day and name
    { $group : { _id : { name: "$name" }, total: { $sum: "$count" } } } 

])