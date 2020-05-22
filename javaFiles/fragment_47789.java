{ $project: {  
      _id: 0,
      name: "$_id",
      count: 1,
      sum: 1
   }
}