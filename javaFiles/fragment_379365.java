db.collection_name.aggregate({
  "$group": {
    "_id": "$name",
    "qualifiedPreviousCount": {
      "$sum": {
        "$cond": [
          {
            "$and": [
              {
                "$gte": [
                  "$previousCount",
                  40
                ]
              },
              {
                "$lte": [
                  "$previousCount",
                  70
                ]
              }
            ]
          },
          1,
          0
        ]
      }
    },
    "qualifiedCurrentCount": {
      "$sum": {
        "$cond": [
          {
            "$and": [
              {
                "$gte": [
                  "$currentCount",
                  10
                ]
              },
              {
                "$lte": [
                  "$currentCount",
                  50
                ]
              }
            ]
          },
          1,
          0
        ]
      }
    }
  }
})