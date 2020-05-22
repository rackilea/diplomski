db.labServiceMasters.aggregate([
  { "$project": {
    "subDepartmentList": {
      "$arrayElemAt": [
        { "$filter": {
          "input": {
            "$map": {
              "input": "$subDepartmentList",
              "as": "sd",
              "in": {
                "$arrayElemAt": [
                  { "$filter": {
                    "input": "$$sd.labServiceList",
                    "as": "ls",
                    "cond": { "$eq": [ "$$ls._id", "123abc" ] }
                  }},
                  0
                ]  
              }
            }
          },
          "as": "sd",
          "cond": { "$ne": [ "$$sd", null ] }
        }},
        0
      ]
    }  
  }}
])