{
    "bool" : {
        "should" : [ {
            "terms" : {
                "lang" : [ "en" ]
            }
        },{
            "terms" : {
                "location" : [ "pa" ]
            }
        },{
            "bool" : {
                "must" : {
                    "term" : {
                         "title" : "conversion"
                    }
                },
                "should" : {
                    "terms" : {
                        "title" : [ "americanlegion", "conversion" ]
                     }
                }
            }
       } ]
   }
}