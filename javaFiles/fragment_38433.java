{ 
    "aggregate" : "__collection__" ,
    "pipeline" : [ 
        { "$group" : { "_id" : "$postId" } },
        { "$skip" : 1 },
        { "$limit" : 1 }
    ]
}