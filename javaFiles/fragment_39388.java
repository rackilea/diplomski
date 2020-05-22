// change type of deleted_id to your primary key's type.
create table deleted_audit ( deleted_id BIGINT, dt TIMESTAMP, count INT );

DELIMITER $$

CREATE TRIGGER count_deleted BEFORE delete ON a 
FOR EACH ROW 
BEGIN
   DECLARE count_items INT;
   SELECT count(*) FROM b WHERE a_id=OLD.id INTO count_items;
   INSERT INTO deleted_audit VALUES( OLD.id, NOW(), count_items);
END; $$

DELIMITER ;