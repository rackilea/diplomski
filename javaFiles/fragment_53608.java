CREATE DEFINER=`root`@`localhost` TRIGGER before_insert_registration
BEFORE INSERT ON registration 
FOR EACH ROW
BEGIN

DECLARE num_rows INTEGER;

Declare x INTEGER;
SET x = NEW.course_id;

SELECT 
    COUNT(*)
INTO num_rows FROM  courses
WHERE
    course_id = NEW.course_id
        AND maxsize > students_registered;

    IF num_rows < 1 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Testing Custom Fail-Over';
    END IF;
END