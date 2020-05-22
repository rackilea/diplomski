db.collection.find({
  $expr: {
    $gte: [
      {$dateFromString: {
           dateString: "$record.Date_Of_Birth", 
           format: "%m/%d/%Y", 
           timeZone: "EST5EDT"}},
      {$dateFromString: {
           dateString: "9/25/2018", 
           format: "%m/%d/%Y", 
           timeZone: "EST5EDT"}}
    ]
  }
})