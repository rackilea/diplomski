{ "$match": {
    "userId": { "$in": [1,2] },
    "status": 1
  }},
  { "$group": {
    "_id": "$itemId",
    "count": { "$sum": 1 }
  }},
  { "$match": { "count": { "$gt": 1 } } }