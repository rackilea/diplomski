SELECT  city, province, population
    FROM  canada AS a
    JOIN ( SELECT  id
            FROM  canada
            ORDER BY  city
            LIMIT  300,20    -- I used bigger numbers
         ) AS x USING(id);