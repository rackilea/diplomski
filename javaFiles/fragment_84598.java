query ="DELETE FROM TgCalFac 
        WHERE 
        annee LIKE '"+anneePlus+"' 
        AND 
        versionFac LIKE '"+version+"'
        AND DAYOFMONTH(dft) = 31 AND MONTH(dft) = 12";