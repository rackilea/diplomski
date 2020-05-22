db.collection.aggregate([
    { $match: { _id: new ObjectId("526d89571cd72ce9dbb6b443") } },
    { $unwind: "$array" },
    { $sort: { "array.value": -1 } },
    { $group: { 
        _id: null, 
        text: { $first: "$array.text" }, 
        value: { $max: "$array.value" } 
    } }
]);