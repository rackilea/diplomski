db.foo.aggregate([
  {$unwind: "$city"},
  { $project:
       { matches:
            { $eq:[ '$bornIn', '$city.name' ] }
       } 
  }, 
  { $match:
        { matches:true }

  }
]);