{ 
    "aggregate" : "__collection__" , 
    "pipeline" : [ 
        { "$group" : { 
            "_id" : "$searchTerm" , 
            "dateAddToSet" : { "$addToSet" : "$date" }
        }}, 
        { "$project" : { 
            "_id" : 0 ,
            "searchTerm" : "$_id" , 
            "percent" : { "$divide" : [ { "$size" : "$dateAddToSet" } , 28] }
        }}
    ]
}