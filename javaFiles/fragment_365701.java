OPTIONAL MATCH (n:User { name:{1} })
WITH (CASE WHEN n IS NULL THEN [1] ELSE [] END ) AS todo
FOREACH (x IN todo | CREATE (:User { name:{1} }))
WITH todo
MATCH (n:User { name:{1} })
RETURN n;