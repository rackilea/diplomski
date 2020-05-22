db.collection.aggregate([
    // Get only records created in the last 30 days
    {$match:{
          "createdTimestamp":{$gt: new Date(ISODate().getTime() - 1000*60*60*24*30)}
    }}, 
    // Get the year, month and day from the createdTimeStamp
    {$project:{
          "year":{$year:"$createdTimestamp"}, 
          "month":{$month:"$createdTimestamp"}, 
          "day": {$dayOfMonth:"$createdTimestamp"}
    }}, 
    // Group by year, month and day and get the count
    {$group:{
          _id:{year:"$year", month:"$month", day:"$day"}, 
          "count":{$sum:1}
    }}
])