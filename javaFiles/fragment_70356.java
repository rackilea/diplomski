{
  "size" : 0,
  "aggregations" : {
    "agg" : {
      "global" : { },
      "aggregations" : {
        "genders" : {
          "terms" : {
            "field" : "gender",
            "size" : 10,
            "min_doc_count" : 1,
            "shard_min_doc_count" : 0,
            "show_term_doc_count_error" : false,
            "order" : [
              {
                "_count" : "desc"
              },
              {
                "_term" : "asc"
              }
            ]
          }
        }
      }
    }
  }
}