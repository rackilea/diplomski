db.sample.aggregate([
  { "$match": {
    "show.season.episodes.metaTags": "Arya Stark"
  }},
  { "$project": {
    "show": {
      "$setDifference": [
        { "$map": {
          "input": "$show",
          "as": "show",
          "in": {
            "$let": {
              "vars": {
                "season": {
                  "$setDifference": [
                    { "$map": {
                      "input": "$$show.season",
                      "as": "season",
                      "in": {
                        "$let": {
                          "vars": {
                            "episodes": {
                              "$setDifference": [
                                { "$map": {
                                  "input": "$$season.episodes",
                                  "as": "episode",
                                  "in": {
                                    "$cond": [
                                      { "$setIsSubset": [
                                        "$$episode.metaTags",
                                        ["Arya Stark"]
                                      ]},
                                      "$$episode",
                                      false
                                    ]
                                  }
                                }},
                                [false]
                              ]
                            }
                          },
                          "in": {
                            "$cond": [
                              { "$ne": [ "$$episodes", [] ] },
                              {
                                "_id": "$$season._id", 
                                "episodes": "$$episodes"
                              },
                              false
                            ]
                          }
                        }
                      }
                    }},
                    [false]
                  ]
                }
              },
              "in": {
                "$cond": [
                  { "$ne": ["$$season", [] ] },
                  {
                    "name": "$$show.name",
                    "season": "$$season"
                  },
                  false
                ]
              }
            }
          }
        }},
        [false]
      ]
    }
  }}
])