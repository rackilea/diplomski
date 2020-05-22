'$pipeline' : [
  {
    '$project' : {
      a : 1,
      b : 1,
      c : 1,
      etc : 1,
      myfieldnameExists : {
        '$cond' : [
          {
            '$eq' : [
              {
                '$ifNull' : [
                  '$myfieldname', 
                  ObjectId('52cb94836c4a28185433c4d3')
                ]
              }, 
              ObjectId('52cb94836c4a28185433c4d3')
            ]
          }, 
          0, 
          1
        ]
      }
    }
  }, 
  {
    '$group' : {
      '_id' : 'a',
      count : { '$sum' : '$myfieldnameExists' }
    }
  }
]
[{
  '_id' : 'a',
  count : 66
}]