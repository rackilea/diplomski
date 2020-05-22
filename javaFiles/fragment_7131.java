CREATE TRIGGER last_parent_id_check BEFORE UPDATE ON child
FOR EACH ROW
BEGIN
    IF NEW.parent_id <> OLD.parent_id THEN
        SET NEW.last_parent_id = OLD.parent_id;
    END IF;
END;