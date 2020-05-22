[
  {
    "$match": {
      "hourNumber": 21,
      "errorSegments.agentName": "agentX"
    }
  },
  {
    "$project": {
      "errorSegments": {
        "$filter": {
          "input": "$errorSegments",
          "as": "e",
          "cond": {
            "$eq": [
              "$$e.agentName",
              "agentX"
            ]
          }
        }
      }
    }
  },
  {
    "$unwind": "$errorSegments"
  },
  {
    "$replaceRoot": {
      "newRoot": "$errorSegments"
    }
  }
]