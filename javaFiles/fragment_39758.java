{
  "query": {
    "match_all": {}
  },
  "aggs": {
    "agg": {
      "filter": {
        "bool": {
          "must": [
            {
              "terms": {
                "Name": [
                  "stokes",
                  "roshan"
                ]
              }
            },
            {
              "range": {
                "grade": {
                  "lte": 9
                }
              }
            }
          ]
        }
      },
      "aggs": {
        "by_year": {
          "terms": {
            "field": "year"
          },
          "aggs": {
            "sum_marks": {
              "sum": {
                "field": "marks"
              }
            },
            "sum_grade": {
              "sum": {
                "field": "grade"
              }
            }
          }
        }
      }
    }
  }
}