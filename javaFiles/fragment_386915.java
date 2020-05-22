{
    "$and": [
        {
            "$or": [
                {
                    "user.id" : <id>
                },
                {
                    "retweeted_status.user.id": <id>
                }
            ]
        },
        {
            "$and": [
                {
                    "date_posted": {
                        "$gt": <dateFrom>
                    }
                },
                {
                    "date_posted": {
                        "$lt": <dateFrom>
                    }
                }
            ]
        }
    ]
}