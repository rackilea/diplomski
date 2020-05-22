SELECT 
    test_colum,  
(IF((POSITION('73|' IN test_colum))=1,1,0))
+
  ( ROUND (   
        (
            (LENGTH(test_colum)
            - LENGTH( REPLACE ( test_colum, "|73|", "")) 
            ) 
        ) / LENGTH("|73|")        
    ) 
+
IF((substring_index(test_colum,'|',-1) = '73'),1,0)) AS value_cnt
FROM test_table;