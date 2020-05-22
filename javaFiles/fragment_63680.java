INSERT INTO detail (carID, finish, color) 
    SELECT ?, ?, color
    FROM car 
    WHERE NOT EXISTS (SELECT carID 
                      FROM detail 
                      WHERE carID = ?
                     ) ;