db.collection.aggregate([
{
  $project: {
    _id: 1,
    total: 1,
    myArray: 1,
    arraySize: { $size: "$myArray"} // count the size of your array
  }
},
{
  $unwind: "$myArray" // flatten your array
},
{
  $group: {
    _id: {id: "$_id", value: "$myArray.value"},
    total: { $first: "$total"},
    myArray: { $first: "$myArray"},
    arraySize: { $first: "$arraySize" },
    countVal: { $sum: 1} // count the occurrence of value out of total array size in each document  
  }
},
{
  $project: {
    _id: 1,
    divmulti: { "$multiply": [ { "$divide": ["$countVal","$arraySize"] }, "$total" ] } 
  }
},
{
  $group: {
    _id: "$_id.value", // group by value
    "linear_total": { $sum: "$divmulti" } // and some the results
  }
}
])