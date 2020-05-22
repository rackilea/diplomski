{ $and : 
    [{
       $and: 
        [
         {$or : [ { $where: '?0 == null' } , { a : ?0 }]}, 
         {$or : [ { $where: '?1 == null' } , { b : ?1 }]},
         {$or : [ { $where: '?2 == null' } , { c : ?2 }]}
        ]
    }]
}