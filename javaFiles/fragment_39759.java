"aggregations": {
      "agg": {
         "doc_count": 2,
         "by_year": {
            "doc_count_error_upper_bound": 0,
            "sum_other_doc_count": 0,
            "buckets": [
               {
                  "key": 2015,
                  "doc_count": 2,
                  "sum_grade": {
                     "value": 18
                  },
                  "sum_marks": {
                     "value": 176
                  }
               }
            ]
         }
      }
   }