db.test.aggregate(
  {$match:{"array.1":{$in:[100, 140,80]}}}, // filter to the ones that match
  {$unwind:"$array.1"}, // unwinds the array so we can match the items individually
  {$group: { // groups the array back, but adds a count for the number of matches
    _id:"$_id", 
    matches:{
      $sum:{
        $cond:[
          {$eq:["$array.1", 100]}, 
          1, 
          {$cond:[
            {$eq:["$array.1", 140]}, 
            1, 
            {$cond:[
              {$eq:["$array.1", 80]}, 
              1, 
              0
              ]
            }
            ]
          }
          ]
        }
      }, 
    item:{$first:"$array.item"}, 
    "1":{$push:"$array.1"}
    }
  }, 
  {$sort:{matches:-1}}, // sorts by the number of matches descending
  {$project:{matches:1, array:{item:"$item", 1:"$1"}}} // rebuilds the original structure
);