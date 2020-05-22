db.MyCollection.aggregate([
    {$match: {_id: {$in: ['A', 'B', 'C']}}},
    {$project: {"fields": "$nested.field"}},
    {$unwind: "$fields"},
    {$group: {_id: "$_id", "maxVersion": {$max: "$fields.version"}}}
])