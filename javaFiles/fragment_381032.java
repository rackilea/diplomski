db.collectionName.aggregate({
"$unwind": "$192_168_10_17"
}, {
"$match": {
    "192_168_10_17.type": "User.Notice"
}
}, {
"$group": {
    "_id": "$192_168_10_17.type",
    "count": {
        "$sum": 1
    }
}
}, {
"$project": {
    "_id": 0,
    "count": "$count"
}
})