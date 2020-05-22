db.records.find(
    {
        "$or": [
            { "authorId": searchId },
            { "comments.userId": searchId }
        ]
    }
)