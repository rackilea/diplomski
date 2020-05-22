CREATE TRIGGER update_formatted_elapse
AFTER UPDATE OF lap_time_ms ON MyTable
FOR EACH ROW
BEGIN
    UPDATE MyTable
    SET formatted_elapse = strftime('%M:%f', NEW.lap_time_ms, 'unixepoch')
    WHERE _id = NEW._id;
END;