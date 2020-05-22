db.collection.aggregate([
     { "$match": {
         "g": "$in": [ 32008, 11989 ]
     }},
    { "$group": {
        "_id": {
             "agnt_id": "$agnt_id",
             "g": "$g"
         }
    }}
 ])