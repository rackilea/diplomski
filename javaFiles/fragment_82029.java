CREATE (p1:Product {id: 1, amount: 30}),
       (p2:Product {id: 2, amount: 20}),
       (p3:Product {id: 3, amount: 10}),
       (p4:Product {id: 4, amount: 40}),
       (p1)-[:COSTS]->(p2),
       (p2)-[:COSTS]->(p3),
       (p2)-[:COSTS]->(p4)