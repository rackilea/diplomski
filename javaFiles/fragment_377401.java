SELECT REFERENCE_NO, 
       ITEM_NO, 
       ROLES = STUFF((SELECT N', ' + ENTITY_ROLE 
                      FROM dbo.MyTable AS p2
                      WHERE p2.ITEM_NO = p.ITEM_NO 
                      ORDER BY ENTITY_ROLE
                      FOR XML PATH(N'')), 1, 2, N'')
FROM dbo.MyTable AS p
GROUP BY REFERENCE_NO, ITEM_NO
ORDER BY ITEM_NO;