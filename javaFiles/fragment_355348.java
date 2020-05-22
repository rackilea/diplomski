DELIMITER $$

CREATE    
    PROCEDURE `getAllUnAssignedUSER`() 

    BEGIN
    SELECT * FROM platform_Users pu WHERE pu.id NOT IN (SELECT DISTINCT id FROM Assigned_Users);
    END$$

DELIMITER ;