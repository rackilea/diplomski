db.collection_name.aggregate([
  {
    "$redact": {
      "$cond": [
        {
          "$let": {
            "vars": {
              "subelems": {
                "$objectToArray": "$foo"
              }
            },
            "in": {
              "$in": [
                "A",
                "$$subelems.v.type"
              ]
            }
          }
        },
        "$$KEEP",
        "$$PRUNE"
      ]
    }
  }
])