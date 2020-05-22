{
    "aggs" : {
        "devices" : {
            "terms" : { "field" : "deviceField" },
             "aggs" : {
                "avg_pression" : { "avg" : { "field" : "pressionField" } }
           }
        }
    }
}